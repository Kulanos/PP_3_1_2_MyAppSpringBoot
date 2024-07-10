package org.kulanos.pp_3_1_2_myappspringboot.dao;



import org.kulanos.pp_3_1_2_myappspringboot.model.User;

import java.util.List;

public interface UserDAO {


    public List<User> allUsers();

    public void add(User user);

    public void delete(User user);

    public void edit(User user);

    public User getById(Long id);
}

