package com.mongotest.procedure.repository;

import com.mongotest.procedure.entity.SapProcess;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SapProcessRepository  extends MongoRepository<SapProcess, String> {

    @Query("{'PROCESS_NAME': ?0}")
    SapProcess findByProcessName(String processName);
}
