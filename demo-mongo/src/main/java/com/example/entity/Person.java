package com.example.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Person {
    private String id;
    @DBRef(db = "account")
    private List<Account> accounts;
}
