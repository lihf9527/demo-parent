package com.example.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;
}
