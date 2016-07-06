package com.kknyrik.euro2016.dao;

import com.kknyrik.euro2016.config.PersistenceConfig;
import com.kknyrik.euro2016.model.Player;
import com.kknyrik.euro2016.model.Team;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.HashSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class,
        TeamsDaoTest.TestConfiguration.class }, loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class TeamsDaoTest {
    @Configurable
    @ComponentScan(basePackages = { "com.kknyrik.euro2016.dao" })
    static class TestConfiguration {
    }

    @Autowired
    TeamDao teamDao;
    @Autowired
    PlayersDao playersDao;

    @Test
    public void add_NewRecord_RecordCreated() {
        Team team = new Team();
        team.setCountry("USA");
        team.setPlayers(new HashSet<>());

        Player player = createPlayer();
        team.getPlayers().add(player);
        player.setTeam(team);
        teamDao.add(team);

        System.out.println(player.getId());
        System.out.println(playersDao.find(2).getTeam().getCountry());
    }

    private Player createPlayer() {
        Player p = new Player();
        p.setFirstName("Vasya");
        p.setLastName("Vasya");
        p.setNumber(10);
        return p;
    }
}

