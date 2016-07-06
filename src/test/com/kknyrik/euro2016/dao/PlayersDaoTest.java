package com.kknyrik.euro2016.dao;

import com.kknyrik.euro2016.config.PersistenceConfig;
import com.kknyrik.euro2016.config.RootConfig;
import com.kknyrik.euro2016.model.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class,
        PlayersDaoTest.TestConfiguration.class }, loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class PlayersDaoTest {
    @Configurable
    @ComponentScan(basePackages = { "com.kknyrik.euro2016.dao" })
    static class TestConfiguration {
    }

    @Autowired
    PlayersDao playerDao;

    @Test
    public void add_NewRecord_RecordCreated() {
        Player p = new Player();
        p.setFirstName("Vasya");
        p.setLastName("Vasya");
        p.setNumber(10);
        playerDao.add(p);
    }


}
