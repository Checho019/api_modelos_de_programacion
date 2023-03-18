package com.example.api.controller;

import com.example.api.entity.Role;
import com.example.api.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleRestController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles")
    public List<Role> showRoles(){
        return (List<Role>) roleRepository.findAll();
    }

    @PostMapping("/roles/saverole")
    public String saveRole(@RequestBody Role role){
        roleRepository.save(role);
        return "the role has been save";
    }

}
