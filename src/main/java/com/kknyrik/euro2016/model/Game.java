package com.kknyrik.euro2016.model;

import javax.persistence.*;

@Entity
public class Game extends AbstractEntity {

    @OneToOne
    private Team firstTeam;
    @OneToOne
    private Team secondTeam;
    private Integer firstTeamGoals;
    private Integer secondTeamGoals;
    @ManyToOne
    private Groups groups;

    public Game(){}

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

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }
}
