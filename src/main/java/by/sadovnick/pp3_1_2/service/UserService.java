package by.sadovnick.pp3_1_2.service;


import by.sadovnick.pp3_1_2.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}
