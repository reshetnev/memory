package com.epam.reshetnev.memory.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.epam.reshetnev.memory.core.entity.Group;
import com.epam.reshetnev.memory.core.repository.GroupRepository;
import com.epam.reshetnev.memory.core.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

    private static final Logger LOG = Logger.getLogger(GroupServiceImpl.class);

    @Autowired
    private GroupRepository groupRepository;

    @Override
    @Transactional(readOnly = true, propagation=Propagation.SUPPORTS)
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    @Transactional
    public Group add(Group group) throws Exception {

        Group savedGroup = groupRepository.save(group);

        LOG.info("New group: [{}] successfully created " + savedGroup.toString());

        return savedGroup;
    }

    @Override
    @Transactional(readOnly = true, propagation=Propagation.SUPPORTS)
    public Group getById(Integer id) throws Exception {

        Group group = groupRepository.findOne(id);

        return group;
    }

    @Override
    @Transactional(readOnly = true, propagation=Propagation.SUPPORTS)
    public Group getByName(String name) {
        return groupRepository.findByName(name);
    }

    @Override
    @Transactional
    public Group update(Integer id, Group newGroup) throws Exception {

        Group group = groupRepository.findOne(id);
        group.setName(newGroup.getName());
        group.setCodes(newGroup.getCodes());

        LOG.info("Group: [{}] successfully updated " + group.toString());

        return group;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        groupRepository.delete(id);
    }

}
