package com.example.jdbc;

import lombok.Data;

import java.time.LocalDateTime;

// 实体类
@Data
public class Customer {

    private Long id;

    private String customerName;

    private LocalDateTime createTime;

    private LocalDateTime editTime;
}
