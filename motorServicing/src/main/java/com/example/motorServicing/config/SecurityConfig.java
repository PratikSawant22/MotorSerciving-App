package com.example.motorServicing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
	
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
    
    
    
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//      
//        http.authorizeRequests().antMatchers("/login").permitAll()
//                .antMatchers("/product", "/cart").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/product")
//                 .permitAll()
//                .and()
//                .logout().logoutUrl("/logout");
// 
//        http.headers().frameOptions().sameOrigin();
// 
//        return http.build();  	
//    }
 
}
	