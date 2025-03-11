package com.mongotest.procedure.repository;

import com.mongotest.procedure.entity.SapsLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SapsLogRepository  extends MongoRepository<SapsLog, String> {
}
