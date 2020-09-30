package com.yjx.controller;

import com.yjx.entity.Admin;
import com.yjx.entity.User;
import com.yjx.feign.AdminFeign;
import com.yjx.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientHandler {

    @Autowired
    private UserFeign userFeign;
    @Autowired
    private AdminFeign adminFeign;

    @GetMapping("/user/findAll")
    public List<User> findAlluser() {
        return userFeign.findAll();
    }

    @GetMapping("/admin/findAll")
    public List<Admin> findAlladmin() {
        return adminFeign.findAll();
    }




}
