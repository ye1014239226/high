package com.yjx.repository;

import com.yjx.entity.Admin;

import java.util.List;

public interface AdminRepository {
    public List<Admin> findAll();

    Admin login(String admin_name,String admin_pwd);

    Admin regist(String admin_name,String admin_pwd);
}
