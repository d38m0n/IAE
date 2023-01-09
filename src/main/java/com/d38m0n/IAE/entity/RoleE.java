package com.d38m0n.IAE.entity;

import javax.persistence.*;

@Entity
public class RoleE {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 45)
    private String name;

    public RoleE() {
    }

    public RoleE(String name) {
        this.name = name;
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
