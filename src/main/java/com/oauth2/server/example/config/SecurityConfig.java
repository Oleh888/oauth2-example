package com.oauth2.server.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilter(new AuthorizationFilter(authenticationManager()))
                .authorizeRequests()
                .antMatchers("/authorize/**", "/token/**").permitAll()
                .anyRequest().authenticated();
    }
}
