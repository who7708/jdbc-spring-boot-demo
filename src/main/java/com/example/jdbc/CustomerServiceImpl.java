package com.example.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Chris
 * @version 1.0.0
 * @since 2023-08-25
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDaoJDK customerDaoJDK;

    // @Transactional(rollbackFor = Exception.class)
    @Override
    public Customer insertSelective(Customer customer) throws Exception {
        Customer customerRes = customerDaoJDK.insertSelective(customer);
        if (customerRes.getId() % 2 == 0) {
            throw new Exception("异常了");
        }
        return customerRes;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Customer insertSelective2(Customer customer) throws Exception {
        Customer customerRes = customerDaoJDK.insertSelective(customer);
        if (customerRes.getId() % 2 == 0) {
            throw new Exception("异常了");
        }
        return customerRes;
    }
}
