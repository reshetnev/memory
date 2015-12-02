package com.epam.reshetnev.memory.core.config.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder registry) throws Exception {
        /*
        registry
        .inMemoryAuthentication()
        .withUser("siva")
          .password("siva")
          .roles("USER")
          .and()
        .withUser("admin")
          .password("admin")
          .roles("ADMIN","USER");
        */
        
        //registry.jdbcAuthentication().dataSource(dataSource);
        registry.userDetailsService(customUserDetailsService);
    }


//      @Override
//      public void configure(WebSecurity web) throws Exception {
//        web
//          .ignoring()
//             .antMatchers("/resources/**");
//      }

      @Override
      protected void configure(HttpSecurity http) throws Exception {
        http
          .httpBasic()
        .and()
          .authorizeRequests()
            .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
            .anyRequest().authenticated();
      }
}
