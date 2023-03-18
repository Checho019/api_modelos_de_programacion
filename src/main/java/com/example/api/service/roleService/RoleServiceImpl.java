package com.example.api.service.roleService;

import com.example.api.entity.Role;
import com.example.api.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Role> findRole() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Role findRoleByRoleName(String id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteRoleByName(String roleName) {
        roleRepository.deleteById(roleName);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
