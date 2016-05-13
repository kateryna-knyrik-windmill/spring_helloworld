package com.kknyrik.euro2016.controller;

import com.kknyrik.euro2016.players.model.Player;
import com.kknyrik.euro2016.config.URLConstants;
import com.kknyrik.euro2016.players.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Katerina.Knyrik on 5/12/16.
 */
@RestController
@RequestMapping(value = "/players")
public class PlayersController {

    private PlayerService playerService;

    @Autowired
    public PlayersController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(URLConstants.GET_ALL_PLAYERS)
    @ResponseBody
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @RequestMapping(URLConstants.GET_PLAYER)
    @ResponseBody
    public Player getById(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    @RequestMapping(value=URLConstants.ADD_PLAYER, method=RequestMethod.POST)
    @ResponseBody
    public String addPlayer(Player player) {
        playerService.addPlayer(player);
        return "Saved player: " + player.toString();
    }

    @RequestMapping(URLConstants.DELETE_PLAYER)
    @ResponseBody
    public boolean deleteById(@PathVariable int id) {
        return playerService.deletePlayer(id);
    }

}
