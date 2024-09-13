package web.service;

import web.model.User;

import java.util.List;

public interface ServiceUser {

    List<User> getAllUsers();

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}
