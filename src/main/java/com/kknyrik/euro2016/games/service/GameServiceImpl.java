package com.kknyrik.euro2016.games.service;


import com.kknyrik.euro2016.dao.GameDao;
import com.kknyrik.euro2016.games.model.Game;
import com.kknyrik.euro2016.teams.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {


    @Autowired
    GameDao gameDao;

    @Override
    public List<Game> getAll() {
        return gameDao.getAll(Game.class);
    }

    @Override
    public Game getGameById(int id) {
        return gameDao.find(id);
    }

    @Override
    public List<Game> getGamesForTeam(Team team) {
        List<Game> games = new ArrayList<>();
        games.stream().forEach((game) -> {
            if(game.getFirstTeam().getId().equals(team.getId())){
                games.add(game);
            }
        });
        return games;
    }

    @Override
    public List<Game> getGamesBetweenTeams(Team firstTeam, Team secondTeam) {
        return null;
    }

}
