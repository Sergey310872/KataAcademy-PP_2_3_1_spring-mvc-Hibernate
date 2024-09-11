package web.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

//@Component
@Repository
public class UserDAOImp implements UserDAO{

    @Autowired
    private EntityManager entityManager;

    private EntityTransaction transaction = null;

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
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            if (user.getId() == null) {
                entityManager.persist(user);
            } else {
                User userDB = entityManager.find(User.class, user.getId());
                userDB.setName(user.getName());
                userDB.setLastName(user.getLastName());
                userDB.setAge(user.getAge());
            }
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public void deleteUser(Long id) {
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            User userDB = entityManager.find(User.class, id);
            entityManager.remove(userDB);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}