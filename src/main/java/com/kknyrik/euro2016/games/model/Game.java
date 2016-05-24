package com.kknyrik.euro2016.games.model;
import com.kknyrik.euro2016.teams.model.Team;

import javax.persistence.*;

@Entity
public class Game {

    @Id
    private Integer id;
    @OneToOne
    private Team firstTeam;
    @OneToOne
    private Team secondTeam;
    private Integer firstTeamGoals;
    private Integer secondTeamGoals;

    public Game(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public Integer getFirstTeamGoals() {
        return firstTeamGoals;
    }

    public void setFirstTeamGoals(Integer firstTeamGoals) {
        this.firstTeamGoals = firstTeamGoals;
    }

    public Integer getSecondTeamGoals() {
        return secondTeamGoals;
    }

    public void setSecondTeamGoals(Integer secondTeamGoals) {
        this.secondTeamGoals = secondTeamGoals;
    }
}
