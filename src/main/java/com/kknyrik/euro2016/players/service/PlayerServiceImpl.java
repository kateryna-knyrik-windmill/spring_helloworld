package com.kknyrik.euro2016.players.service;

import com.kknyrik.euro2016.players.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina.Knyrik on 5/12/16.
 */

@Service
public class PlayerServiceImpl implements PlayerService {

    ArrayList<Player> playerArrayList = new ArrayList<Player>();
    {
        playerArrayList.add(new Player(0, "first", "firstTeam"));
        playerArrayList.add(new Player(1, "second", "secondTeam"));
        playerArrayList.add(new Player(2, "third", "thirdTeam"));
    }

    /**
     *
     * @return list of players
     */
    public List<Player> getAllPlayers() {
        return this.playerArrayList;
    }

    /**
     *
     * @param id
     * @return player by id
     */
    public Player getPlayer(int id) {
        if(playerArrayList.size() <= id)
            return this.playerArrayList.get(id);
        return new Player();
    }

    /**
     *
     * @param player
     * @return boolean value is player was added
     */
    public boolean addPlayer(Player player) {
        return this.playerArrayList.add(player);
    }

    /**
     *
     * @param id player id
     * @return boolean value is player was deleted
     */
    public boolean deletePlayer(int id) {
        if(this.playerArrayList.contains(getPlayer(id))){
            this.playerArrayList.remove(id);
        } return false;
    }
}
