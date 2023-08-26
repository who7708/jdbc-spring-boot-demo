package com.example.jdbc;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Chris
 * @version 1.0.0
 * @since 2023-08-25
 */
public interface CustomerService {
    @Transactional(rollbackFor = Exception.class)
    Customer insertSelective(Customer customer) throws Exception;
}
