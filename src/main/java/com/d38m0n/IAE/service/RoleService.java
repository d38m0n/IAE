package com.d38m0n.IAE.service;

import com.d38m0n.IAE.entity.RoleEntity;
import com.d38m0n.IAE.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
@Autowired
    private RoleRepository roleRepository;


    public List<RoleEntity> listRoles() {
        return roleRepository.findAll();
    }
}
