package com.example.jdbc;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Chris
 */
public interface CustomerDaoJDK {

    /**
     * 增
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    Customer insertSelective(Customer customer) throws Exception;

    // int delete(long id);
    //
    // /**
    //  * 查
    //  */
    // Customer queryByCustomerName(String customerName);
    //
    // /**
    //  * 查
    //  */
    // Customer queryById(long id);
    //
    // List<Customer> queryAll();
    //
    // int updateByPrimaryKeySelective(Customer customer);
    //
    // static Customer convert(ResultSet rs) throws SQLException {
    //     Customer customer = new Customer();
    //     customer.setId(rs.getLong("id"));
    //     customer.setCustomerName(rs.getString("customer_name"));
    //     customer.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
    //     customer.setEditTime(rs.getTimestamp("edit_time").toLocalDateTime());
    //     return customer;
    // }
}
