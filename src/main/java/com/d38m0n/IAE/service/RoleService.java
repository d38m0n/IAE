package com.d38m0n.IAE.service;


import com.d38m0n.IAE.entity.RoleE;
import com.d38m0n.IAE.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepository;


    public List<RoleE> listRoles() {
        return roleRepository.findAll();
    }
    public void addRole(RoleE source){
        roleRepository.save(source);
    }
}