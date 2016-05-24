package com.kknyrik.euro2016.teams.service;


import com.kknyrik.euro2016.players.model.Player;
import com.kknyrik.euro2016.teams.model.Team;

import java.util.List;

public interface TeamService {

    List<Team> getAllTeams();
    void addTeam(Team team);
    void deleteTeam(int id);
    Team getTeamById(int id);
    Player getTeamByPlayer(Player player);
    void addPlayerToTeam(Player player);
    boolean deletePlayerFromTeam(Player player);
}
