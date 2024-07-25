package com.example.mongodbtest.controller;

import com.example.mongodbtest.dto.CreateCrawlingDto;
import com.example.mongodbtest.dto.ResponseDto;
import com.example.mongodbtest.service.CrawlingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crawling")
public class CrawlingController {
    private final CrawlingService crawlingService;

    @GetMapping("")
    public ResponseDto<?> getCrawling(@RequestParam String name) {
        return ResponseDto.ok(crawlingService.getCrawling(name));
    }

    @PostMapping("")
    public ResponseDto<?> createCrawling(@RequestBody CreateCrawlingDto createCrawlingDto) {
        return ResponseDto.created(crawlingService.createCrawling(createCrawlingDto.name(), createCrawlingDto.age()));
    }

    @PutMapping("")
    public ResponseDto<?> updateCrawling(@RequestBody CreateCrawlingDto createCrawlingDto) {
        return ResponseDto.ok(crawlingService.updateCrawling(createCrawlingDto.name(), createCrawlingDto.age()));
    }

    @DeleteMapping("")
    public ResponseDto<?> deleteCrawling(@RequestParam String name) {
        return ResponseDto.ok(crawlingService.deleteCrawling(name));
    }
}
