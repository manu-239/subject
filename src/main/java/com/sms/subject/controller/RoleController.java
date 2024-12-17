package com.sms.subject.controller;

import com.sms.subject.entity.Role;
import com.sms.subject.service.RoleService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    RoleService roleService;


    @PostMapping("/role")
    public String addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

    @DeleteMapping("/role/{id}")
    public String addRole(@PathParam("id") Long id){
        return roleService.deleteRole(id);
    }


}
