package com.kknyrik.euro2016.controller;

import com.kknyrik.euro2016.exceptions.ExceptionService;
import com.kknyrik.euro2016.model.Team;
import com.kknyrik.euro2016.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/team")
public class TeamsController {

    private final TeamService teamService;

    @Autowired
    public TeamsController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Team getTeamById(@PathVariable int id) throws ExceptionService.TeamNotFoundException {
        if (id > 0 && isTeamExists(id)){
            return teamService.getTeamById(id);
        } else {
            throw new ExceptionService.TeamNotFoundException("cannot find team by id " + id);
        }
    }

    private boolean isTeamExists(int id) {
        return teamService.checkIfExists(id);
    }

    @RequestMapping (value="/addTeam", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody void addTeam(@RequestBody Team team) throws ExceptionService.TeamNotFoundException, ExceptionService.DuplicateTeamException {
        if(!getAllTeams().contains(team)){
            teamService.addTeam(team);
        } else {
            throw new ExceptionService.DuplicateTeamException(team.getCountry());
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody void deleteById(@PathVariable int id) throws ExceptionService.TeamNotFoundException {
        teamService.deleteTeam(id);
    }
}
