package com.yjx.feign;


import com.yjx.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {


    @GetMapping("/user/findAll")
    public List<User>  findAll();
}
