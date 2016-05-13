package com.kknyrik.euro2016.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Katerina.Knyrik on 5/12/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.kknyrik.euro2016", includeFilters = @ComponentScan.Filter({
        Configuration.class }))
public class RootConfig {
}
