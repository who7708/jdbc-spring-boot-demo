package com.example.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * @author Chris
 */
@Service
// 构造方法上增加 @Autowired 注解
// JDK 1.7
// @RequiredArgsConstructor(onConstructor = @__({@Autowired}))
// JDK 1.8+
// @RequiredArgsConstructor(onConstructor_ = {@Autowired})
// 构造方法上没有 @Autowired 注解
@RequiredArgsConstructor
public class CustomerDaoJDKImpl implements CustomerDaoJDK {

    private final JdbcTemplate jdbcTemplate;

    /**
     * 增
     * @return
     */
    // @Transactional(rollbackFor = Exception.class)
    @Override
    public Customer insertSelective(Customer customer) throws Exception {
        StringJoiner p = new StringJoiner(",", "(", ")");
        StringJoiner v = new StringJoiner(",", "(", ")");
        Optional.ofNullable(customer.getCustomerName()).ifPresent(x -> {
            p.add("customer_name");
            v.add("?");
        });
        Optional.ofNullable(customer.getCreateTime()).ifPresent(x -> {
            p.add("create_time");
            v.add("?");
        });
        Optional.ofNullable(customer.getEditTime()).ifPresent(x -> {
            p.add("edit_time");
            v.add("?");
        });
        String sql = "INSERT INTO customer" + p.toString() + " VALUES " + v.toString();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int updateCount = jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int index = 1;
            if (null != customer.getCustomerName()) {
                ps.setString(index++, customer.getCustomerName());
            }
            if (null != customer.getCreateTime()) {
                ps.setTimestamp(index++, Timestamp.valueOf(customer.getCreateTime()));
            }
            if (null != customer.getEditTime()) {
                ps.setTimestamp(index, Timestamp.valueOf(customer.getEditTime()));
            }
            return ps;
        }, keyHolder);
        customer.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return customer;
    }

    // /**
    //  * 删
    //  */
    // @Override
    // @Transactional(rollbackFor = Exception.class)
    // public int delete(long id) {
    //     return jdbcTemplate.update("DELETE FROM customer WHERE id = ?", id);
    // }
    //
    // /**
    //  * 查
    //  */
    // @Override
    // public Customer queryByCustomerName(String customerName) {
    //     return jdbcTemplate.query("SELECT * FROM customer WHERE customer_name = ?",
    //             ps -> ps.setString(1, customerName), SINGLE);
    // }
    //
    // /**
    //  * 查
    //  */
    // @Override
    // public Customer queryById(long id) {
    //     return jdbcTemplate.query("SELECT * FROM customer WHERE id = ?",
    //             ps -> ps.setLong(1, id), SINGLE);
    // }
    //
    // @Override
    // public List<Customer> queryAll() {
    //     return jdbcTemplate.query("SELECT * FROM customer", MULTI);
    // }
    //
    // @Override
    // @Transactional(rollbackFor = Exception.class)
    // public int updateByPrimaryKeySelective(Customer customer) {
    //     final long id = Objects.requireNonNull(Objects.requireNonNull(customer).getId());
    //     StringBuilder sql = new StringBuilder("UPDATE customer SET ");
    //     Optional.ofNullable(customer.getCustomerName()).ifPresent(x -> sql.append("customer_name = ?,"));
    //     Optional.ofNullable(customer.getCreateTime()).ifPresent(x -> sql.append("create_time = ?,"));
    //     Optional.ofNullable(customer.getEditTime()).ifPresent(x -> sql.append("edit_time = ?,"));
    //     StringBuilder q = new StringBuilder(sql.substring(0, sql.lastIndexOf(","))).append(" WHERE id = ?");
    //     return jdbcTemplate.update(q.toString(), ps -> {
    //         int index = 1;
    //         if (null != customer.getCustomerName()) {
    //             ps.setString(index++, customer.getCustomerName());
    //         }
    //         if (null != customer.getCreateTime()) {
    //             ps.setTimestamp(index++, Timestamp.valueOf(customer.getCreateTime()));
    //         }
    //         if (null != customer.getEditTime()) {
    //             ps.setTimestamp(index++, Timestamp.valueOf(customer.getEditTime()));
    //         }
    //         ps.setLong(index, id);
    //     });
    // }
    //
    // private static ResultSetExtractor<List<Customer>> MULTI = rs -> {
    //     List<Customer> result = new ArrayList<>();
    //     while (rs.next()) {
    //         result.add(CustomerDaoJDK.convert(rs));
    //     }
    //     return result;
    // };
    //
    // private static ResultSetExtractor<Customer> SINGLE = rs -> rs.next() ? CustomerDaoJDK.convert(rs) : null;
}
