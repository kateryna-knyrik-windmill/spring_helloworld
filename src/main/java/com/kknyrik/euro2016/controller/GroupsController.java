package com.kknyrik.euro2016.controller;

import com.kknyrik.euro2016.model.Groups;
import com.kknyrik.euro2016.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/groups")
public class GroupsController {

    @Autowired
    private final GroupService groupService;

    @Autowired
    public GroupsController(GroupService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Groups> getAll() {
        return groupService.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Groups getById(@PathVariable int id) {
        return groupService.getById(id);
    }

    @RequestMapping(value= "/add", method=RequestMethod.POST)
    public @ResponseBody
    void addGroup(@RequestBody Groups groups) {
        groupService.addGroup(groups);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteById(@PathVariable int id) {
        groupService.removeGroup(id);
    }
}
