package com.example.jdbc;// package com.example.other.jdbc;
//
// import lombok.RequiredArgsConstructor;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.ResultSetExtractor;
// import org.springframework.jdbc.support.GeneratedKeyHolder;
// import org.springframework.jdbc.support.KeyHolder;
// import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;
//
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.sql.Timestamp;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Objects;
// import java.util.Optional;
// import java.util.StringJoiner;
//
// /**
//  * @author Chris
//  */
// @Repository
// // 构造方法上增加 @Autowired 注解
// // JDK 1.7
// // @RequiredArgsConstructor(onConstructor = @__({@Autowired}))
// // JDK 1.8+
// // @RequiredArgsConstructor(onConstructor_ = {@Autowired})
// // 构造方法上没有 @Autowired 注解
// @RequiredArgsConstructor
// public class CustomerDao {
//
//     private final JdbcTemplate jdbcTemplate;
//
//     /**
//      * 增
//      */
//     @Transactional(rollbackFor = Exception.class)
//     public int insertSelective(Customer customer) {
//         StringJoiner p = new StringJoiner(",", "(", ")");
//         StringJoiner v = new StringJoiner(",", "(", ")");
//         Optional.ofNullable(customer.getCustomerName()).ifPresent(x -> {
//             p.add("customer_name");
//             v.add("?");
//         });
//         Optional.ofNullable(customer.getCreateTime()).ifPresent(x -> {
//             p.add("create_time");
//             v.add("?");
//         });
//         Optional.ofNullable(customer.getEditTime()).ifPresent(x -> {
//             p.add("edit_time");
//             v.add("?");
//         });
//         String sql = "INSERT INTO customer" + p.toString() + " VALUES " + v.toString();
//         KeyHolder keyHolder = new GeneratedKeyHolder();
//         int updateCount = jdbcTemplate.update(con -> {
//             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//             int index = 1;
//             if (null != customer.getCustomerName()) {
//                 ps.setString(index++, customer.getCustomerName());
//             }
//             if (null != customer.getCreateTime()) {
//                 ps.setTimestamp(index++, Timestamp.valueOf(customer.getCreateTime()));
//             }
//             if (null != customer.getEditTime()) {
//                 ps.setTimestamp(index, Timestamp.valueOf(customer.getEditTime()));
//             }
//             return ps;
//         }, keyHolder);
//         customer.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
//         return updateCount;
//     }
//
//     /**
//      * 删
//      */
//     @Transactional(rollbackFor = Exception.class)
//     public int delete(long id) {
//         return jdbcTemplate.update("DELETE FROM customer WHERE id = ?", id);
//     }
//
//     /**
//      * 查
//      */
//     public Customer queryByCustomerName(String customerName) {
//         return jdbcTemplate.query("SELECT * FROM customer WHERE customer_name = ?",
//                 ps -> ps.setString(1, customerName), SINGLE);
//     }
//
//     /**
//      * 查
//      */
//     public Customer queryById(long id) {
//         return jdbcTemplate.query("SELECT * FROM customer WHERE id = ?",
//                 ps -> ps.setLong(1, id), SINGLE);
//     }
//
//     public List<Customer> queryAll() {
//         return jdbcTemplate.query("SELECT * FROM customer", MULTI);
//     }
//
//     @Transactional(rollbackFor = Exception.class)
//     public int updateByPrimaryKeySelective(Customer customer) {
//         final long id = Objects.requireNonNull(Objects.requireNonNull(customer).getId());
//         StringBuilder sql = new StringBuilder("UPDATE customer SET ");
//         Optional.ofNullable(customer.getCustomerName()).ifPresent(x -> sql.append("customer_name = ?,"));
//         Optional.ofNullable(customer.getCreateTime()).ifPresent(x -> sql.append("create_time = ?,"));
//         Optional.ofNullable(customer.getEditTime()).ifPresent(x -> sql.append("edit_time = ?,"));
//         StringBuilder q = new StringBuilder(sql.substring(0, sql.lastIndexOf(","))).append(" WHERE id = ?");
//         return jdbcTemplate.update(q.toString(), ps -> {
//             int index = 1;
//             if (null != customer.getCustomerName()) {
//                 ps.setString(index++, customer.getCustomerName());
//             }
//             if (null != customer.getCreateTime()) {
//                 ps.setTimestamp(index++, Timestamp.valueOf(customer.getCreateTime()));
//             }
//             if (null != customer.getEditTime()) {
//                 ps.setTimestamp(index++, Timestamp.valueOf(customer.getEditTime()));
//             }
//             ps.setLong(index, id);
//         });
//     }
//
//     private static Customer convert(ResultSet rs) throws SQLException {
//         Customer customer = new Customer();
//         customer.setId(rs.getLong("id"));
//         customer.setCustomerName(rs.getString("customer_name"));
//         customer.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
//         customer.setEditTime(rs.getTimestamp("edit_time").toLocalDateTime());
//         return customer;
//     }
//
//     private static ResultSetExtractor<List<Customer>> MULTI = rs -> {
//         List<Customer> result = new ArrayList<>();
//         while (rs.next()) {
//             result.add(convert(rs));
//         }
//         return result;
//     };
//
//     private static ResultSetExtractor<Customer> SINGLE = rs -> rs.next() ? convert(rs) : null;
// }
