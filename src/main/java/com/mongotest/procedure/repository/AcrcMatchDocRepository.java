package com.mongotest.procedure.repository;

import com.mongotest.procedure.entity.AcrcMatchDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcrcMatchDocRepository extends MongoRepository<AcrcMatchDoc, String> {

    @Query("{'MATCH_DOC': ?0}")
    List<AcrcMatchDoc> findByMatchDoc(String matchDoc);

    @Query("{'POL_NO': ?0}")
    List<AcrcMatchDoc> findByPolicyNumber(String polNo);
}
