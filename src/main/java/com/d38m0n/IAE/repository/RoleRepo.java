package com.d38m0n.IAE.repository;

import com.d38m0n.IAE.entity.RoleE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo  extends JpaRepository<RoleE,Integer> {
    RoleE findByName(String admin);
}
