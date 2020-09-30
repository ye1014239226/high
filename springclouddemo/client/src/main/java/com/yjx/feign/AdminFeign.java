package com.yjx.feign;

import com.yjx.entity.Admin;
import com.yjx.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "admin")
public interface AdminFeign {

    @GetMapping("/admin/findAll")
    public List<Admin> findAll();
}
