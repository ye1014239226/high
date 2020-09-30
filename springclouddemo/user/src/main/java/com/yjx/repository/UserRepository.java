package com.yjx.repository;

import com.yjx.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> findAll();
}
