package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUser();

    public User getUserById(Long id);

    public void updateUser(User user);

    public void deleteUser(Long id);
}
