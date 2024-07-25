package com.example.mongodbtest.repository;

import com.example.mongodbtest.domain.CrawlingInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CrawlingRepository extends MongoRepository<CrawlingInfo, String> {
    Optional<CrawlingInfo> findByName(String name);
}
