package com.mongotest.procedure.service.impl;

import com.mongotest.procedure.entity.SapsProcess;
import com.mongotest.procedure.repository.SapsProcessRepository;
import com.mongotest.procedure.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private SapsProcessRepository sapsProcessRepository;

    @Override
    public void updateProcessStatus(String status, String vPROCESS_NAME) {
        Optional<SapsProcess> processOpt = sapsProcessRepository.findByProcessName(vPROCESS_NAME);
        if (processOpt.isPresent()) {
            SapsProcess process = processOpt.get();
            process.setLastEndDate(new Date());
            process.setLastRunStat(status);
            sapsProcessRepository.save(process);
        }
    }
}
