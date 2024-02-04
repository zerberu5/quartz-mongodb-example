package org.quartzer.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class MyData {
    @Id
    private String id;
    private int value;


    // getters and setters
}