package com.kknyrik.euro2016.controller;

import com.kknyrik.euro2016.players.model.Player;
import com.kknyrik.euro2016.players.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        System.out.println("get all");
        return playerService.getAllPlayers();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Player getById(@PathVariable int id) {
        return playerService.getPlayer(id);
    }

    @RequestMapping(value= "/add", method=RequestMethod.POST)
    @ResponseBody
    public void addPlayer(@RequestBody Player player) {
        System.out.println("add");
        playerService.addPlayer(player);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable int id) {
        playerService.deletePlayer(id);
    }

}
