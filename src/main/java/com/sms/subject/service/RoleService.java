package com.sms.subject.service;

import com.sms.subject.entity.Role;
import com.sms.subject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public String addRole(Role role){
        roleRepository.save(role);
        return "Role added successfully";
    }

    public String deleteRole(Long id) {
        roleRepository.deleteById(id);
        return "Role deleted successfully";
    }
}
