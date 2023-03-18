package com.example.api.service.userService;

import com.example.api.entity.User;
import com.example.api.repository.UserReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserReposiroty userReposiroty;

    @Autowired
    UserServiceImpl(UserReposiroty userReposiroty){
        this.userReposiroty = userReposiroty;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findUsers() {
        return userReposiroty.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(long id) {
        return userReposiroty.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userReposiroty.deleteById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userReposiroty.save(user);
    }
}
