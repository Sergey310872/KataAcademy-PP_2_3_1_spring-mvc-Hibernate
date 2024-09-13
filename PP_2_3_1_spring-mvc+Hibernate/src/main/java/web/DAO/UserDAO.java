package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUser();

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}
