package com.kknyrik.euro2016.controller;


import com.kknyrik.euro2016.model.Game;
import com.kknyrik.euro2016.service.GameService;
import com.kknyrik.euro2016.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/game")
public class GamesController {

    private final GameService gameService;

    @Autowired
    public GamesController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Game> getAll(){
        return gameService.getAll();
    }

    @RequestMapping(value = "/addGame", method = RequestMethod.POST)
    public @ResponseBody void addGameBetweenTeams(@RequestBody Game game){
        gameService.addGame(game);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Game getGameById(@PathVariable int id){
        return gameService.getGameById(id);
    }

    @RequestMapping(value = "/get/{team}", method = RequestMethod.GET)
    public List<Game> getGamesForTeam(Team team){
        return gameService.getGamesForTeam(team);
    }

    @RequestMapping(value = "/get/{firstTeam}&{secondTeam}", method = RequestMethod.GET)
    List<Game> getGamesBetweenTeams(Team firstTeam, Team secondTeam){
        return gameService.getGamesBetweenTeams(firstTeam, secondTeam);
    }
}

