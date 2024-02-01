package web.dao;


import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers(int count);
    void addUser(User user);
    void removeUserById(Long id);
    User getUserById(Long id);
    void updateUser(long id, User user);
}
