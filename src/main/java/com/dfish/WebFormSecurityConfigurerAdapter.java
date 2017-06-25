package com.dfish;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Administrator on 2017/6/21 0021.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebFormSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/picture/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();

    }


}
