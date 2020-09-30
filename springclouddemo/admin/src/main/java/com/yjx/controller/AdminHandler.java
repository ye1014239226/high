package com.yjx.controller;

import com.yjx.entity.Admin;
import com.yjx.entity.Result;
import com.yjx.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminHandler {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/findAll")
    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    @RequestMapping(value = "/login")
    public Result login( Admin requestAdmin){

        requestAdmin = adminRepository.login(requestAdmin.getAdmin_name(),requestAdmin.getAdmin_pwd());

        if(requestAdmin!=null){
            return new Result(200);
        }else{
            return new Result(400);
        }
    }

    @RequestMapping(value = "/regist")
    public Result regist( Admin requestAdmin){



        requestAdmin = adminRepository.regist(requestAdmin.getAdmin_name(),getMD5(requestAdmin.getAdmin_pwd()));

        if(requestAdmin!=null){
            return new Result(200);
        }else{
            return new Result(400);
        }
    }


    /*@PostMapping(value = "/login")
    public Result login(@RequestBody Admin requestAdmin){
        requestAdmin = adminRepository.login(requestAdmin.getAdmin_name(),requestAdmin.getAdmin_pwd());

        if(requestAdmin!=null){
            return new Result(200);
        }else{
            return new Result(400);
        }

    }*/


    public static String getMD5(String key) {
        try {
            //生成一个完全随机的的byte数组
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] bytes = new byte[32];
            secureRandom.nextBytes(bytes);
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //将此byte数组转换成16进制的字符串作为随机盐值
            String salt = DatatypeConverter.printHexBinary(bytes);
            String password = key + salt;
            // 计算md5函数
            md.update(password.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}