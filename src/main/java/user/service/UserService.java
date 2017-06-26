package user.service;

import user.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(Long id);
    User getUserById(Long id);
    List<User> listUsers();

    List<User> filteredUsers(String type);

    void fillUsers();
}
