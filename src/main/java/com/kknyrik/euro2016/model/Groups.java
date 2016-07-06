package com.kknyrik.euro2016.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Groups extends AbstractEntity{

    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "groups", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Game> game;

    public Groups() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return game;
    }

    public void setGames(List<Game> game) {
        this.game = game;
    }
}
