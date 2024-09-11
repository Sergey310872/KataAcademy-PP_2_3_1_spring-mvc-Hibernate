package web.service;

import web.model.User;

import java.util.List;

public interface ServiceUser {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public void updateUser(User user);

    public void deleteUser(Long id);
}
