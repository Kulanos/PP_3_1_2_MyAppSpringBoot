package org.kulanos.pp_3_1_2_myappspringboot.service;


import org.kulanos.pp_3_1_2_myappspringboot.dao.UserDAO;
import org.kulanos.pp_3_1_2_myappspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImp implements UserService{

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userDAO.getById(id);
    }
}
