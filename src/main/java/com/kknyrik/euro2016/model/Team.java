package com.kknyrik.euro2016.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Team extends AbstractEntity{

    private String country;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Player> players;

    public Team() {
    }

    public Set<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(Set<Player> playersList) {
        this.players = playersList;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

