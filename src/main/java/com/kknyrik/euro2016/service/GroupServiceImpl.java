package com.kknyrik.euro2016.service;

import com.kknyrik.euro2016.dao.GroupDao;
import com.kknyrik.euro2016.model.Game;
import com.kknyrik.euro2016.model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    GroupDao groupDao;

    @Override
    public void addGroup(Groups groups) {
        groupDao.add(groups);
    }

    @Override
    public void removeGroup(Integer id) {
        groupDao.remove(groupDao.find(id));
    }

    @Override
    public Groups getById(Integer id) {
        return groupDao.find(id);
    }

    @Override
    public List<Groups> getAll() {
        return groupDao.getAll(Groups.class);
    }

    @Override
    public List<Game> getGamesForGroup(String groupName) {
        return null;
    }
}
