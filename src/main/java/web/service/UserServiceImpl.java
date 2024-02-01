package web.service;

import org.springframework.stereotype.Component;
import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    private List<User> users;

    @Override
    public List<User> getAllUsers(int count) {
        return userDAO.getAllUsers(count);
    }
}
