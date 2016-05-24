package com.kknyrik.euro2016.players.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kknyrik.euro2016.teams.model.Team;

import javax.persistence.*;

@Entity
public class Player{

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private Integer number;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Team team;

    @JsonBackReference
    public Team getTeam() {
        return this.team;
    }

    public Player() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player [id= " + id + ",  firstName=" + firstName +  "]";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
