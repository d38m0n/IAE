package com.d38m0n.IAE.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ROLES")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 45)
    private String name;

    public RoleEntity() {
    }

    public RoleEntity(String name) {
        this.name = name;
    }

    public RoleEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleEntity(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

