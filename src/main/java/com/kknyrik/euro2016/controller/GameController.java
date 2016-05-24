package com.kknyrik.euro2016.controller;


import com.kknyrik.euro2016.games.model.Game;
import com.kknyrik.euro2016.games.service.GameService;
import com.kknyrik.euro2016.teams.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Game> getAll(){
        return gameService.getAll();
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

