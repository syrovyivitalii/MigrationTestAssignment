package com.mongotest.procedure.repository;

import com.mongotest.procedure.entity.SapsProcess;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SapsProcessRepository   extends MongoRepository<SapsProcess, String> {

    Optional<SapsProcess> findByProcessName(String processName);
}
