package com.example.entity.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {
    private String id;
    @NonNull
    private String name;
    @DBRef(lazy = true)
    private List<Account> accounts;
}
