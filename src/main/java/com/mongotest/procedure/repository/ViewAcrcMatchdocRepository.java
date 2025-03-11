package com.mongotest.procedure.repository;

import com.mongotest.procedure.entity.ViewAcrcMatchdoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewAcrcMatchdocRepository  extends MongoRepository<ViewAcrcMatchdoc, String> {

    @Query("{'MATCH_TYPE': ?0, 'MATCH_DOC': ?1}")
    List<ViewAcrcMatchdoc> findByMatchTypeAndMatchDoc(String matchType, String matchDoc);

    @Query("{'MATCH_DOC': ?0, 'MATCH_TYPE': {$in: ['PL', 'EN']}}")
    List<ViewAcrcMatchdoc> findByMatchDocAndMatchTypeIn(String matchDoc);
}
