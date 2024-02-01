package web.dao;

import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDAOImpl implements UserDAO {

    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User("Roman", "Sharapov", 24));
        users.add(new User("Roman", "Sharapov", 24));
        users.add(new User("Roman", "Sharapov", 24));
        users.add(new User("Roman", "Sharapov", 24));
        users.add(new User("Roman", "Sharapov", 24));
    }

    @Override
    public List<User> getAllUsers(int count) {
        return users.stream().limit(count).collect(Collectors.toList());
    }
}
