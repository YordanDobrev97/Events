package com.example.events.configuration;

import com.example.events.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UsersService usersService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public ApplicationSecurityConfiguration(UsersService usersService,
                                            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersService = usersService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
//                .csrfTokenRepository(csrfTokenRepository())
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/webfonts/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/users/login", "/users/register").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/users/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .and()
                .rememberMe()
                .rememberMeParameter("rememberMe")
                .key("PLYOK")
                .userDetailsService(this.usersService)
                .rememberMeCookieName("KLYOK")
                .tokenValiditySeconds(1200);
    }
}