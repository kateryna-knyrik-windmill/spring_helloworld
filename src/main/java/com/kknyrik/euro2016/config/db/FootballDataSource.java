package com.kknyrik.euro2016.config.db;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Katerina.Knyrik on 5/17/16.
 */
public class FootballDataSource {

    @Profile("h2")
    @Configuration
    public class H2DataSource {

        @Bean
        public DataSource dataSource() {
             return new EmbeddedDatabaseBuilder().addDefaultScripts().build();
        }

        @Bean(initMethod = "start", destroyMethod = "stop")
        public Server startDBManager() throws SQLException {
            return Server.createWebServer();
        }

    }
}
