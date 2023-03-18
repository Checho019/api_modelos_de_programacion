package com.example.api.controller;

import com.example.api.entity.User;
import com.example.api.service.roleService.RoleService;
import com.example.api.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<User> showUsers(){
        return userService.findUsers();
    }
    @PostMapping("/saveuser")
    public String saveUser(@RequestBody User s){
        userService.saveUser(s);
        return "Usuario creado";
    }

    @PutMapping("/updateuser/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        return "Usuario actualizado";
    }

    @DeleteMapping("deleteuser/{id}")
    public String deleteUser(@PathVariable long id){
        userService.deleteUserById(id);
        return "Usuario eliminado";
    }

}
