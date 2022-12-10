package com.d38m0n.IAE.repository;

import com.d38m0n.IAE.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    RoleEntity findByName(String admin);
}
