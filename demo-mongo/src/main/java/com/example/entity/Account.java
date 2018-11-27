package com.example.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Account {
    private String id;
    private Float total;
}
