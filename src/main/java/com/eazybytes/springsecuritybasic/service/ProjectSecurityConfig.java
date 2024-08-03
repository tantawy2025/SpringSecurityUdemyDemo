package com.eazybytes.springsecuritybasic.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/myAccount/**", "/myBalance/**",
                                        "/myLoans/**", "/myCards/**")
                                .authenticated()

                                .requestMatchers("/contact/**","/notices/**")
                                .permitAll()
                ).formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();


    }

}
