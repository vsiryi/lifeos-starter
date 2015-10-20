package com.willbe.lifeos;

import com.willbe.lifeos.repository.UserRepository;
import com.willbe.lifeos.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Creation date: 10/12/15
 *
 * @author Vitalii Siryi
 */
@Configuration
@PropertySources(value = @PropertySource({"classpath:/application.properties","classpath:/db.properties"}))
public class LifeConfiguration {

    @Bean
    public ApplicationSecurity applicationSecurity() {
        return new ApplicationSecurity();
    }

    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    public static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

        @Autowired
        private SecurityProperties security;

        @Autowired
        private UserRepository userRepository;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/hello/**").permitAll()
                    .antMatchers("/rest/**").permitAll()
                    .antMatchers("/resource/**").permitAll()
                    .antMatchers("/*.html").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login").defaultSuccessUrl("/main").failureUrl("/forbidden").permitAll()
                    .and()
                    .rememberMe();

        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(new UserServiceImpl(userRepository));
        }


    }

}
