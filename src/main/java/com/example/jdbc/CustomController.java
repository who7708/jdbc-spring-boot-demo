package com.example.jdbc;// package com.example.other.jdbc;
//
// import lombok.RequiredArgsConstructor;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
//
// import java.util.List;
//
// /**
//  * @author Chris
//  * @version 1.0.0
//  * @since 2023-08-24
//  */
// @RestController
// @RequestMapping("/test/custom")
// @RequiredArgsConstructor
// public class CustomController {
//
//     private final CustomerDao customerDao;
//
//     @RequestMapping("/insert")
//     public Customer insertSelective(@RequestBody Customer customer) throws Exception {
//         int updateCount = customerDao.insertSelective(customer);
//         System.out.println(updateCount);
//         return customer;
//     }
//
//     @RequestMapping("/del")
//     public Customer delete(long id) {
//         int delCount = customerDao.delete(id);
//         System.out.println(delCount);
//         return customerDao.queryById(id);
//     }
//
//     @RequestMapping("/up")
//     public Customer updateByPrimaryKeySelective(@RequestBody Customer customer) {
//         int upCount = customerDao.updateByPrimaryKeySelective(customer);
//         System.out.println(upCount);
//         return customerDao.queryById(customer.getId());
//     }
//
//     @RequestMapping("/query")
//     public List<Customer> queryAll() {
//         return customerDao.queryAll();
//     }
// }
