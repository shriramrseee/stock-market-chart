package com.stock.chart.user;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("P@55w03D").authorities("ROLE_USER")
                .and()
                .withUser("admin").password("@dM1N987").authorities("ROLE_ADMIN");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic().and().authorizeRequests()
                .antMatchers("*/admin/*").hasAuthority("ROLE_ADMIN")
                .antMatchers("/*").hasAuthority("ROLE_USER")
                .anyRequest().permitAll()
                .and().formLogin();
    }

}