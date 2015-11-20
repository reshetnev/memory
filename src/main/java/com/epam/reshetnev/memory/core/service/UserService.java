package com.epam.reshetnev.memory.core.service;

import java.util.List;

import com.epam.reshetnev.memory.core.entity.User;

public interface UserService {

    public List<User> findAll();

    public User findById(Integer id);

    public User save(User user);

    public User update(Integer id, User newUser);

    public User findByEmail(String email);

    public void delete(Integer id);

}
