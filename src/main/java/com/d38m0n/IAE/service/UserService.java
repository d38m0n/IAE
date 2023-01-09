package com.d38m0n.IAE.service;

import com.d38m0n.IAE.entity.RoleE;
import com.d38m0n.IAE.entity.UserE;
import com.d38m0n.IAE.repository.RoleRepo;
import com.d38m0n.IAE.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    final
    RoleRepo roleRepo;

    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }


    public List<UserE> listAll() {
        return userRepo.findAll();
    }

    public void save(UserE user) {
        userRepo.save(user);
    }

    public UserE get(String id) {
        return userRepo.findById(id).orElseThrow();
    }

    public List<RoleE> listRoles() {
        return roleRepo.findAll();
    }

    public void delete(String id) {
        userRepo.deleteById(id);
    }
}
