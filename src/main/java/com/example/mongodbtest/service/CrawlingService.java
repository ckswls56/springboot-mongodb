package com.example.mongodbtest.service;

import com.example.mongodbtest.domain.CrawlingInfo;
import com.example.mongodbtest.exception.CommonException;
import com.example.mongodbtest.exception.ErrorCode;
import com.example.mongodbtest.repository.CrawlingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrawlingService {
    private final CrawlingRepository crawlingRepository;

    public CrawlingInfo getCrawling(String name) {
        CrawlingInfo crawlingInfo = crawlingRepository.findByName(name).orElseThrow(()->new CommonException(ErrorCode.NOT_FOUND_CRAWLING));

        return crawlingInfo;
    }

    public Boolean createCrawling(String name, Long age) {
        CrawlingInfo crawlingInfo = CrawlingInfo.builder()
                .name(name)
                .age(age)
                .build();
        crawlingRepository.save(crawlingInfo);
        return true;
    }

    public Boolean updateCrawling(String name, Long age) {
        CrawlingInfo crawlingInfo = crawlingRepository.findByName(name).orElseThrow(()->new CommonException(ErrorCode.NOT_FOUND_CRAWLING));
        crawlingInfo.updateAge(age);
        crawlingRepository.save(crawlingInfo);
        return true;
    }

    public Boolean deleteCrawling(String name) {
        CrawlingInfo crawlingInfo = crawlingRepository.findByName(name).orElseThrow(()->new CommonException(ErrorCode.NOT_FOUND_CRAWLING));
        crawlingRepository.delete(crawlingInfo);
        return true;
    }

}
