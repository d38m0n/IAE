package com.d38m0n.IAE.service;

import com.d38m0n.IAE.entity.RoleEntity;
import com.d38m0n.IAE.entity.UserEntity;
import com.d38m0n.IAE.repository.RoleRepository;
import com.d38m0n.IAE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;


    public List<UserEntity> listAll() {
        return userRepo.findAll();
    }

    public void save(UserEntity user) {
        userRepo.save(user);
    }

    public UserEntity get(String id) {
        return userRepo.findById(id).orElseThrow();
    }

    public List<RoleEntity> listRoles() {
        return roleRepo.findAll();
    }

    public void delete(String id) {
      userRepo.deleteById(id);
    }
}
