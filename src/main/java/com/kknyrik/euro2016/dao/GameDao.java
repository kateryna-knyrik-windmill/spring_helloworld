package com.kknyrik.euro2016.dao;

import com.kknyrik.euro2016.games.model.Game;
import org.springframework.stereotype.Repository;

@Repository
public class GameDao extends JpaDao<Game,Integer> {
}
