package com.d38m0n.IAE.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.d38m0n.IAE.entity.RoleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateRoles() {
        RoleEntity user = new RoleEntity("User");
        RoleEntity admin = new RoleEntity("Admin");
        RoleEntity customer = new RoleEntity("Customer");
        repo.save(user);

        repo.saveAll(List.of(admin, customer));

        List<RoleEntity> listRoles = repo.findAll();
        assertThat(listRoles.size()).isEqualTo(3);
    }
}