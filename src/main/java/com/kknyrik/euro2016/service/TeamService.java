package com.kknyrik.euro2016.service;


import com.kknyrik.euro2016.exceptions.ExceptionService;
import com.kknyrik.euro2016.model.Player;
import com.kknyrik.euro2016.model.Team;

import java.util.List;

public interface TeamService {

    List<Team> getAllTeams();
    void addTeam(Team team);
    void deleteTeam(int id) throws ExceptionService.TeamNotFoundException;
    Team getTeamById(int id) throws ExceptionService.TeamNotFoundException;
    Player getTeamByPlayer(Player player);
    void addPlayerToTeam(Player player);
    boolean deletePlayerFromTeam(Player player);
    boolean checkIfExists(int id);
}
