package com.kknyrik.euro2016.games.service;

import com.kknyrik.euro2016.games.model.Game;
import com.kknyrik.euro2016.teams.model.Team;

import java.util.List;

public interface GameService {

    List<Game> getAll();
    Game getGameById(int id);
    List<Game> getGamesForTeam(Team team);
    List<Game> getGamesBetweenTeams(Team firstTeam, Team secondTeam);
}
