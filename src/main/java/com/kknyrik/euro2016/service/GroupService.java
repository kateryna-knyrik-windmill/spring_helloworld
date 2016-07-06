package com.kknyrik.euro2016.service;


import com.kknyrik.euro2016.model.Game;
import com.kknyrik.euro2016.model.Groups;

import java.util.List;

public interface GroupService {

    void addGroup(Groups groups);
    void removeGroup(Integer id);
    Groups getById(Integer id);
    List<Groups> getAll();
    List<Game> getGamesForGroup(String groupName);
}
