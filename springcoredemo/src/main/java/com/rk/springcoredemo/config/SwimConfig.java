package com.rk.springcoredemo.config;

import com.rk.springcoredemo.common.Coach;
import com.rk.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwimConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
