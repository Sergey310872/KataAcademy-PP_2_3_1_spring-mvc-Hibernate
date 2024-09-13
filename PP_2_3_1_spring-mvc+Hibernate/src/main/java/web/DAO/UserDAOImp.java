package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Component
@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            User userDB = entityManager.find(User.class, user.getId());
            userDB.setName(user.getName());
            userDB.setLastName(user.getLastName());
            userDB.setAge(user.getAge());
        }
    }

    @Override
    public void deleteUser(Long id) {
        User userDB = entityManager.find(User.class, id);
        entityManager.remove(userDB);
    }
}