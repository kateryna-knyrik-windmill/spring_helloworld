package com.kknyrik.euro2016.service;


import com.kknyrik.euro2016.dao.TeamDao;
import com.kknyrik.euro2016.exceptions.ExceptionService;
import com.kknyrik.euro2016.model.Player;
import com.kknyrik.euro2016.model.Team;
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
    public void deleteTeam(int id) throws ExceptionService.TeamNotFoundException {
        if(checkIfExists(id)){
            teamDao.remove(getTeamById(id));
        } else {
            throw new ExceptionService.TeamNotFoundException("Not found");
        }
    }

    @Override
    public Team getTeamById(int id) throws ExceptionService.TeamNotFoundException {
        if(teamDao.find(id) != null){
            return this.teamDao.find(id);
        } else {
            throw new ExceptionService.TeamNotFoundException("Not found " + id);
        }
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

    @Override
    public boolean checkIfExists(int id) {
        return teamDao.find(id) != null;
    }
}
