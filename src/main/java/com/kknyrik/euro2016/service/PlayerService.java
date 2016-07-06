package com.kknyrik.euro2016.service;

import com.kknyrik.euro2016.model.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();
    Player getPlayer(int id);
    void addPlayer(Player person);
    void deletePlayer(int id);
}
