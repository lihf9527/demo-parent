package com.example.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class DateEntity {
    /**
     * 创建时间
     */
    @CreatedDate
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @LastModifiedDate
    private LocalDateTime updatedTime;
}
