package com.kknyrik.euro2016.service;

import com.kknyrik.euro2016.model.Game;
import com.kknyrik.euro2016.model.Team;

import java.util.List;

public interface GameService {

    void addGame(Game game);
    void deleteGame(Integer id);
    List<Game> getAll();
    Game getGameById(int id);
    List<Game> getGamesForTeam(Team team);
    List<Game> getGamesBetweenTeams(Team firstTeam, Team secondTeam);
}
