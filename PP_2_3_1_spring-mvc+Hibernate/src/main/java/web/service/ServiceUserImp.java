package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.DAO.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class ServiceUserImp implements ServiceUser {
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUser();
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public List<User> deleteUser(Long id) {
        return userDAO.deleteUser(id);
    }
}
