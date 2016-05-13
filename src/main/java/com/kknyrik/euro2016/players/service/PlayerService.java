package com.kknyrik.euro2016.players.service;

import com.kknyrik.euro2016.players.model.Player;

import java.util.List;

/**
 * Created by Katerina.Knyrik on 5/12/16.
 */
public interface PlayerService {

    List<Player> getAllPlayers();
    Player getPlayer(int id);
    boolean addPlayer(Player person);
    boolean deletePlayer(int id);
}
