package com.kknyrik.euro2016.controller;

import com.kknyrik.euro2016.teams.model.Team;
import com.kknyrik.euro2016.teams.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Team getTeamById(@PathVariable int id) {
        return teamService.getTeamById(id);
    }

    @RequestMapping (value="/add/", method = RequestMethod.POST, consumes= "application/json", produces = "application/json")
    public void addTeam(@RequestBody Team team) {
        teamService.addTeam(team);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable int id) {
        teamService.deleteTeam(id);
    }
}
