package com.epam.reshetnev.memory.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.epam.reshetnev.memory.core.entity.User;
import com.epam.reshetnev.memory.core.repository.UserRepository;
import com.epam.reshetnev.memory.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true, propagation=Propagation.SUPPORTS)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true, propagation=Propagation.SUPPORTS)
    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional
    public User save(User user) {

        User savedUser = userRepository.save(user);

        LOG.info("New group: [{}] successfully created " + savedUser.toString());

        return savedUser;
    }

    @Override
    @Transactional
    public User update(Integer id, User newUser) {

        User user = userRepository.findOne(id);
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setCodes(newUser.getCodes());

        userRepository.save(user);

        LOG.info("User: [{}] successfully updated " + user.toString());

        return user;
    }

    @Override
    @Transactional(readOnly = true, propagation=Propagation.SUPPORTS)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        userRepository.delete(id);
    }

}
