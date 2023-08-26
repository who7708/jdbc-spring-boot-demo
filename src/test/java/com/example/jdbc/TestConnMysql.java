package com.example.jdbc;

import com.mysql.jdbc.Driver;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * @author Chris
 * @version 1.0.0
 * @since 2023-08-25
 */
@Slf4j
public class TestConnMysql {

    @Test
    public void test1() throws Exception {
        System.out.println("===== test1 =====");
        Connection conn = null;
        try {
            Class.forName(Driver.class.getName());
            conn = DriverManager.getConnection("jdbc:mysql://192.168.1.5:3305/test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true",
                    "root", "root1234");
            // Do something with the Connection
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM customer WHERE id = 1");
            while (resultSet.next()) {
                log.info("id:{},name:{}", resultSet.getLong("id"), resultSet.getString("customer_name"));
            }
            resultSet.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
