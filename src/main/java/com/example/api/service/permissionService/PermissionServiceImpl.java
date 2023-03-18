package com.example.api.service.permissionService;

import com.example.api.entity.Permission;
import com.example.api.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Permission> getPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Permission findPermission(String permissionName) {
        return permissionRepository.findById(permissionName).orElse(null);
    }
}
