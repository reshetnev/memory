package com.epam.reshetnev.memory.core.service;

import java.util.List;

import com.epam.reshetnev.memory.core.entity.Group;

public interface GroupService {

    public List<Group> getAll();

    public Group getById(Integer id);

    public Group add(Group group);

    public Group getByName(String name);

    public Group update(Integer id, Group newGroup);

    public void delete(Integer id);

}
