package com.kknyrik.euro2016.controller;

import com.kknyrik.euro2016.players.model.Player;
import com.kknyrik.euro2016.players.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Katerina.Knyrik on 5/12/16.
 */
@RestController
@RequestMapping(value = "/players")
public class PlayersController {

    private final PlayerService playerService;

    @Autowired
    public PlayersController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Player getById(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    @RequestMapping(value= "/add/{id}&{name}&{team}", method=RequestMethod.POST)
    public boolean addPlayer(Player player) {
        return playerService.addPlayer(player);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteById(@PathVariable int id) {
        return playerService.deletePlayer(id);
    }

}
