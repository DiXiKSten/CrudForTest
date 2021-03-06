package user.dao;

import user.model.User;

import java.util.Date;
import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user, Date date);
    void removeUser(Long id);
    User getUserById(Long id);
    List<User> listUsers();

    void fillUsers();

    List<User> findUsers(String ids);
}
