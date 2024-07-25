package com.example.mongodbtest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "interpark")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CrawlingInfo {
    @Id
    private String id;
    private String name;
    private Long age;

    public void updateAge(Long age) {
        this.age = age;
    }

}
