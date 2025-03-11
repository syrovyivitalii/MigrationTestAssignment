package com.mongotest.procedure.repository;

import com.mongotest.procedure.entity.SapLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SapLogRepository extends MongoRepository<SapLog, String> {

    @Query("{'PROCESS_NAME': ?0}")
    List<SapLog> findByProcessName(String processName);

    @Query("{'LOG_TIME': {$gte: ?0, $lte: ?1}}")
    List<SapLog> findByLogTimeBetween(LocalDateTime start, LocalDateTime end);
}
