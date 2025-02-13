package com.rk.employeeCRUD.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails rama = User.builder()
                .username("rama")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails krishna = User.builder()
                .username("krishna")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails rk = User.builder()
                .username("rk")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(rama,krishna,rk);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/employees/list").hasRole("EMPLOYEE")
                        .requestMatchers("/employees/addEmployeeForm").hasRole("MANAGER")
                        .requestMatchers("/employees/updateEmployeeForm").hasRole("ADMIN")
                        .requestMatchers("/employees/deleteEmployee").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
                .formLogin(form->
                        form.loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
        );


        return http.build();
    }
}
