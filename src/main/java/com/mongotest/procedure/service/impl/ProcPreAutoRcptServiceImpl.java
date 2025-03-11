package com.mongotest.procedure.service.impl;

import com.mongotest.procedure.entity.AcrcPymtMatch;
import com.mongotest.procedure.entity.AcrcPymtUpload;
import com.mongotest.procedure.entity.ViewAcrcMatchdoc;
import com.mongotest.procedure.repository.AcrcPymtMatchRepository;
import com.mongotest.procedure.repository.AcrcPymtUploadRepository;
import com.mongotest.procedure.repository.ViewAcrcMatchdocRepository;
import com.mongotest.procedure.service.LogService;
import com.mongotest.procedure.service.ProcPreAutoRcptService;
import com.mongotest.procedure.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProcPreAutoRcptServiceImpl implements ProcPreAutoRcptService {
    private final AcrcPymtUploadRepository acrcPymtUploadRepository;

    private final AcrcPymtMatchRepository acrcPymtMatchRepository;

    private final ViewAcrcMatchdocRepository viewAcrcMatchdocRepository;

    private final LogService logService;

    private final ProcessService processService;

    @Autowired
    public ProcPreAutoRcptServiceImpl(AcrcPymtUploadRepository acrcPymtUploadRepository, AcrcPymtMatchRepository acrcPymtMatchRepository, ViewAcrcMatchdocRepository viewAcrcMatchdocRepository, LogService logService, ProcessService processService) {
        this.acrcPymtUploadRepository = acrcPymtUploadRepository;
        this.acrcPymtMatchRepository = acrcPymtMatchRepository;
        this.viewAcrcMatchdocRepository = viewAcrcMatchdocRepository;
        this.logService = logService;
        this.processService = processService;
    }

    private String vFAILED_REMARKS;
    private final String vPROCESS_NAME = "PROC_PRE_AUTO_RCPT";

    @Transactional
    public void runPreAutoRcpt() {
        List<AcrcPymtUpload> cADV_PYMT = acrcPymtUploadRepository.findAdvPymtList();

        for (AcrcPymtUpload advPymt : cADV_PYMT) {
            String vPYMT_NO = advPymt.getPymtNo();
            BigDecimal dMAST_MATCH_ADV_AMT = advPymt.getMatchAdvAmt() == null ? BigDecimal.ZERO : advPymt.getMatchAdvAmt();
            vFAILED_REMARKS = null;

            try {
                BigDecimal dTOTAL_MATCH_ADV_AMT = acrcPymtMatchRepository.sumMatchAdvAmtByPymtNo(vPYMT_NO);
                if (dTOTAL_MATCH_ADV_AMT == null) {
                    dTOTAL_MATCH_ADV_AMT = BigDecimal.ZERO;
                }

                if (dMAST_MATCH_ADV_AMT.compareTo(dTOTAL_MATCH_ADV_AMT) != 0) {
                    vFAILED_REMARKS = "Advance match amount not tally for payment no: " + vPYMT_NO;
                    failedPreAutoRcpt();
                    continue;
                }

                List<AcrcPymtMatch> matches = acrcPymtMatchRepository.findByPymtNoAndMatchAdvAmtGreaterThan(vPYMT_NO, BigDecimal.ZERO);
                for (AcrcPymtMatch match : matches) {
                    BigDecimal dDET_MATCH_ADV_AMT = match.getMatchAdvAmt();
                    String vADV_MATCH_DOC = match.getMatchDoc();
                    String vADV_MATCH_TYPE = match.getMatchType();

                    List<ViewAcrcMatchdoc> docs = viewAcrcMatchdocRepository.findByMatchTypeAndMatchDoc(vADV_MATCH_TYPE, vADV_MATCH_DOC);
                    if (docs.isEmpty()) {
                        continue;
                    }

                    ViewAcrcMatchdoc doc = docs.get(0);
                    String vMATCH_DOC = doc.getMatchDoc();
                    String vPOL_NO = doc.getPolNo();

                    if (vMATCH_DOC != null && vPOL_NO != null) {
                        List<ViewAcrcMatchdoc> polDocs = viewAcrcMatchdocRepository.findByMatchDocAndMatchTypeIn(vPOL_NO);
                        if (polDocs.isEmpty()) {
                            continue;
                        }

                        ViewAcrcMatchdoc polDoc = polDocs.get(0);
                        String vMATCH_TYPE = polDoc.getMatchType();
                        String vPRODUCT_TYPE = polDoc.getProdType();

                        match.setMatchAmt(match.getMatchAmt().add(dDET_MATCH_ADV_AMT));
                        match.setMatchAdvAmt(match.getMatchAdvAmt().subtract(dDET_MATCH_ADV_AMT));
                        match.setMatchType(vMATCH_TYPE);
                        match.setProdType(vPRODUCT_TYPE);
                        match.setMatchDoc(vPOL_NO);
                        acrcPymtMatchRepository.save(match);

                        advPymt.setMatchAmt(advPymt.getMatchAmt().add(dDET_MATCH_ADV_AMT));
                        advPymt.setMatchAdvAmt(advPymt.getMatchAdvAmt().subtract(dDET_MATCH_ADV_AMT));
                        acrcPymtUploadRepository.save(advPymt);
                    }
                }
            } catch (Exception e) {
                logService.logError("Error processing payment: " + vPYMT_NO, vPROCESS_NAME , e);
            }
        }

        processService.updateProcessStatus("S", vPROCESS_NAME);
    }

    public void failedPreAutoRcpt() {
        if (vFAILED_REMARKS != null) {
            logService.logError(vFAILED_REMARKS, vPROCESS_NAME);
        }
    }
}
