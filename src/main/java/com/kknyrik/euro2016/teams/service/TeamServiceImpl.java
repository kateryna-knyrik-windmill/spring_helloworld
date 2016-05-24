package com.kknyrik.euro2016.teams.service;


import com.kknyrik.euro2016.players.model.Player;
import com.kknyrik.euro2016.dao.TeamDao;
import com.kknyrik.euro2016.teams.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamDao teamDao;

    @Override
    public List<Team> getAllTeams() {
        return teamDao.getAll(Team.class);
    }

    @Override
    public void addTeam(Team team) {
        teamDao.add(team);
    }

    @Override
    public void deleteTeam(int id) {
        teamDao.remove(getTeamById(id));
    }

    @Override
    public Team getTeamById(int id) {
        return this.teamDao.find(id);
    }

    @Override
    public Player getTeamByPlayer(Player player) {
        return null;
    }

    @Override
    public void addPlayerToTeam(Player player) {

    }

    @Override
    public boolean deletePlayerFromTeam(Player player) {
        return false;
    }
}
