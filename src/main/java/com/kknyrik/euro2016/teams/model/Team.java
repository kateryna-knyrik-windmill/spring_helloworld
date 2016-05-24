package com.kknyrik.euro2016.teams.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kknyrik.euro2016.players.model.Player;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Team {

    @Id
    private Integer id;
    private String country;
    @ElementCollection(targetClass=Player.class)
    private Set<Player> players = new HashSet<>();

    public Team() {
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    public Set<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(Set<Player> playersList) {
        this.players = playersList;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

