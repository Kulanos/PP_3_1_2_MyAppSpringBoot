package org.kulanos.pp_3_1_2_myappspringboot.dao;






import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.kulanos.pp_3_1_2_myappspringboot.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> allUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }
}