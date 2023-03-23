package com.example.api.controller;

import com.example.api.entity.Permission;
import com.example.api.service.permissionService.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionRestController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/")
    public List<Permission> getPermissions(){
        return permissionService.getPermissions();
    }

    @GetMapping("/{id}")
    public Permission getPermissionByName(@PathVariable String id){
        return permissionService.findPermission(id);
    }

}
