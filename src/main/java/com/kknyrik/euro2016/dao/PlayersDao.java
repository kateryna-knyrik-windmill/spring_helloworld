package com.kknyrik.euro2016.dao;

import com.kknyrik.euro2016.players.model.Player;
import org.springframework.stereotype.Repository;

@Repository
public class PlayersDao extends JpaDao<Player, Integer> {

}
