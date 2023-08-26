package com.example.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * @author Chris
 * @version 1.0.0
 * @since 2023-08-24
 */
@RestController
@RequestMapping("/test2/custom")
@RequiredArgsConstructor
public class CustomControllerJDK {

    private final CustomerService customerService;

    @RequestMapping("/insert")
    public Customer insertSelective(@RequestBody Customer customer) throws Exception {
        Method method = customerService.getClass().getMethod("insertSelective", Customer.class);
        AnnotationAttributes attributes = AnnotatedElementUtils.findMergedAnnotationAttributes(method, Transactional.class, false, false);
        System.out.println(attributes);

        Customer customerRes = customerService.insertSelective(customer);
        System.out.println(customerRes);
        return customerRes;
    }

    // @RequestMapping("/del")
    // public Customer delete(long id) {
    //     int delCount2 = customerDaoJDK.delete(id);
    //     System.out.println(delCount2);
    //     return customerDaoJDK.queryById(id);
    // }
    //
    // @RequestMapping("/up")
    // public Customer updateByPrimaryKeySelective(@RequestBody Customer customer) {
    //     int upCount2 = customerDaoJDK.updateByPrimaryKeySelective(customer);
    //     System.out.println(upCount2);
    //     return customerDaoJDK.queryById(customer.getId());
    // }
    //
    // @RequestMapping("/query")
    // public List<Customer> queryAll() {
    //     return customerDaoJDK.queryAll();
    // }
}
