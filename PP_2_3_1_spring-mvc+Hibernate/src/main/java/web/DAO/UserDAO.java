package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUser();

    public User getUserById(Long id);

    public List<User> updateUser(User user);

    public List<User> deleteUser(Long id);
}
