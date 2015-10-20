package com.willbe.lifeos;

import com.willbe.lifeos.model.UserModel;
import com.willbe.lifeos.repository.UserRepository;
import com.willbe.lifeos.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Creation date: 10/8/15
 *
 * @author Vitalii Siryi
 */
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class LifeOS extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserModel user = userRepository.findByName("admin");
        if(user == null) {
            userRepository.insert(new UserModel("admin", "admin"));
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<LifeOS> applicationClass = LifeOS.class;

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {

            @Override
            public void contextInitialized(ServletContextEvent sce) {
                logger.info("ServletContext initialized");
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                logger.info("ServletContext destroyed");
            }

        };
    }



}
