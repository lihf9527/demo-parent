package com.example.entity.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
@NoArgsConstructor
@RequiredArgsConstructor
public class Account {
    private String id;
    @NonNull
    private BigDecimal money;
}
