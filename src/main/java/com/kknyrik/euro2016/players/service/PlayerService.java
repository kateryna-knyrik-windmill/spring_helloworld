package com.kknyrik.euro2016.players.service;

import com.kknyrik.euro2016.players.model.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();
    Player getPlayer(int id);
    void addPlayer(Player person);
    void deletePlayer(int id);
}
