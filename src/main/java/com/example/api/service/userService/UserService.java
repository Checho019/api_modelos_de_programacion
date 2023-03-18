package com.example.api.service.userService;

import com.example.api.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findUsers();
    public User findUserById(long id);
    public void deleteUserById(long id);
    public void saveUser(User user);


}
