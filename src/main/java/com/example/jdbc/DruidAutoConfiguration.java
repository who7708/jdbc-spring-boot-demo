package com.example.jdbc;// package com.example.other.jdbc;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.core.JdbcTemplate;
//
// import javax.sql.DataSource;
//
// /**
//  * @author Chris
//  */
// @Configuration
// public class DruidAutoConfiguration {
//     @Bean
//     public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//         return new JdbcTemplate(dataSource);
//     }
//
//     // @Bean
//     // @ConfigurationProperties(prefix = "druid")
//     // public DataSource dataSource() {
//     //     return new DruidDataSource();
//     // }
//
//     // @Bean
//     // public ServletRegistrationBean<StatViewServlet> statViewServlet() {
//     //     ServletRegistrationBean<StatViewServlet> servletRegistrationBean
//     //             = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
//     //     // 添加IP白名单
//     //     servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//     //     // 添加控制台管理用户
//     //     servletRegistrationBean.addInitParameter("loginUsername", "admin");
//     //     servletRegistrationBean.addInitParameter("loginPassword", "123456");
//     //     // 是否能够重置数据
//     //     servletRegistrationBean.addInitParameter("resetEnable", "true");
//     //     return servletRegistrationBean;
//     // }
//     //
//     // @Bean
//     // public FilterRegistrationBean<WebStatFilter> webStatFilter() {
//     //     WebStatFilter webStatFilter = new WebStatFilter();
//     //     FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>();
//     //     filterRegistrationBean.setFilter(webStatFilter);
//     //     // 添加过滤规则
//     //     filterRegistrationBean.addUrlPatterns("/*");
//     //     // 忽略过滤格式
//     //     filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,");
//     //     return filterRegistrationBean;
//     // }
// }
