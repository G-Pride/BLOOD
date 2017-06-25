package com.dfish.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/5/25 0025.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue
    private int id;
    private String name ;//权限名
    private boolean enabled;//权限职责
    private String description;//权限描述

    @OneToMany
    private Set<User> users = new HashSet<>();

    public Role() {
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
