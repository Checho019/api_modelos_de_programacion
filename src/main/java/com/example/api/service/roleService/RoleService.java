package com.example.api.service.roleService;

import com.example.api.entity.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findRole();
    public Role findRoleByRoleName(String id);
    public void deleteRoleByName(String roleName);
    public void saveRole(Role role);

}
