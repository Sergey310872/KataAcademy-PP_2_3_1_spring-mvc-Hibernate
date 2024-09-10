package web.service;

import web.model.User;

import java.util.List;

public interface ServiceUser {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public List<User> updateUser(User user);

    public List<User> deleteUser(Long id);
}
