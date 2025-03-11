package com.mongotest.procedure.service;

import org.springframework.transaction.annotation.Transactional;

public interface ProcPreAutoRcptService {
    @Transactional
    void runPreAutoRcpt();

    void failedPreAutoRcpt();
}
