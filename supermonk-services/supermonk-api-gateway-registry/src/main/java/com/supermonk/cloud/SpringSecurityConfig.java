package com.supermonk.cloud;

public class SpringSecurityConfig {}

//extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("{noop}admin").password("admin").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("{noop}act").password("act").roles("ACTUATOR");
////        User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();
//    }
//}