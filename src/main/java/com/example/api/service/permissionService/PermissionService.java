package com.example.api.service.permissionService;

import com.example.api.entity.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> getPermissions();
    Permission findPermission(String permissionName);
}
