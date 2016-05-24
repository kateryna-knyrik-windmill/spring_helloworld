package com.kknyrik.euro2016.players.service;

import com.kknyrik.euro2016.dao.PlayersDao;
import com.kknyrik.euro2016.players.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayersDao playersDao;

    /**
     *
     * @return list of players
     */
    public List<Player> getAllPlayers() {
        return playersDao.getAll(Player.class);
    }

    /**
     *
     * @param id
     * @return player by id
     */
    public Player getPlayer(int id) {
        return this.playersDao.find(id);
    }


    /**
     *
     * @param player
     *
     */
    public void addPlayer(Player player) {
        this.playersDao.add(player);
    }

    /**
     *
     * @param id player id
     * @return
     */
    public void deletePlayer(int id) {
        playersDao.remove(getPlayer(id));
    }
}
