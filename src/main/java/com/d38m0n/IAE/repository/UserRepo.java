package com.d38m0n.IAE.repository;

import com.d38m0n.IAE.entity.UserE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserE,String>{

}
