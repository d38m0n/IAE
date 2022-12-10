package com.d38m0n.IAE.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.d38m0n.IAE.entity.RoleEntity;
import com.d38m0n.IAE.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Test
    public void testCreateUser() {
        UserEntity user = new UserEntity();
        user.setEmail("ravikumar@gmail.com");
        user.setPassword("ravi2020");
        user.setFirstName("Ravi");
        user.setLastName("Kumar");

        UserEntity savedUser = userRepo.save(user);
        UserEntity existUser = entityManager.find(UserEntity.class, savedUser.getId());
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }

    @Test
    public void testAddRoleToNewUser() {
        RoleEntity admin = new RoleEntity("Admin");
        roleRepo.save(admin);
        RoleEntity roleAdmin = roleRepo.findByName("Admin");

        UserEntity user = new UserEntity();
        user.setEmail("mikes.gates@gmail.com");
        user.setPassword("mike2020");
        user.setFirstName("Mike");
        user.setLastName("Gates");
        user.addRole(roleAdmin);

        UserEntity savedUser = userRepo.save(user);
        assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }
}
