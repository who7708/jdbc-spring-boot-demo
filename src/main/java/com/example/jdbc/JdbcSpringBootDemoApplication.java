package com.example.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Arrays;

/**
 * @author Chris
 * @version 1.0.0
 * @since 2023-08-25
 */
@Slf4j
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication(scanBasePackages = "com.example.jdbc")
public class JdbcSpringBootDemoApplication {
    @Autowired
    private DataSource dataSource;

    // @Autowired
    // private CustomerDao customerDao;

    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(JdbcSpringBootDemoApplication.class, args);
        // new SpringApplicationBuilder()
        //         .sources(JdbcSpringBootDemoApplication.class)
        //         // .web(WebApplicationType.NONE)
        //         // .web(WebApplicationType.SERVLET)
        //         .web(false)
        //         .run(args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            testConn(ctx);
            // testJdbcTemplate(ctx);
        };
    }

    // private void testJdbcTemplate(ApplicationContext ctx) throws Exception {
    //     Customer customer = new Customer();
    //     customer.setCustomerName("doge");
    //     int r = customerDao.insertSelective(customer);
    //     log.info("insert customer[doge],result:{},id:{}", r, customer.getId());
    //
    //     customer.setCustomerName("throwableDoge");
    //     r = customerDao.updateByPrimaryKeySelective(customer);
    //     log.info("update customer[doge->throwableDoge],result:{}", r);
    //
    //     Customer result = customerDao.queryByCustomerName("throwable");
    //     log.info("select customer[customerName=throwable],result:{}", objectMapper.writeValueAsString(result));
    //
    //     List<Customer> all = customerDao.queryAll();
    //     log.info("select all customer,result:{}", objectMapper.writeValueAsString(all));
    //
    //     r = customerDao.delete(customer.getId());
    //     log.info("delete customer[id={}],result:{}", customer.getId(), r);
    // }

    private void testConn(ApplicationContext ctx) throws Exception {
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        Connection connection = dataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM customer WHERE id = 1");
        while (resultSet.next()) {
            log.info("id:{},name:{}", resultSet.getLong("id"), resultSet.getString("customer_name"));
        }
        resultSet.close();
        connection.close();
    }

}
