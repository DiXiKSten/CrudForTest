package user.dao;

import user.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        if (user.getId() == null) {
            this.em.persist(user);
        } else {
            this.em.merge(user);
        }
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return em.createQuery("from users ").getResultList();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> filteredUsers(String type) {
        return em.createQuery(
                "SELECT user FROM users user WHERE user.isAdmin = :done ORDER BY user.name")
                .setParameter("done", type.equals("Admin"))
                .getResultList();
    }

    @Override
    @Transactional
    public void fillUsers() {
        Random random = new Random();
        String[] ranName ={"Dima","Petya","Misha","Alex","Ulya","Masha","Olga","Klava"};
        for (int i=0; i<5; i++) {
            User user = new User();
            user.setIsAdmin(random.nextBoolean());
            user.setName(ranName[(int) (Math.random()*7)]);
            user.setAge((int) (Math.random()*50)+1);
            addUser(user);
        }
    }
}
