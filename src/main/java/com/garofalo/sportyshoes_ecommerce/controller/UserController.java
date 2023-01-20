package com.garofalo.sportyshoes_ecommerce.controller;

import com.garofalo.sportyshoes_ecommerce.entity.UserEntity;
import com.garofalo.sportyshoes_ecommerce.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/allusers")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/user/{id}")
    public UserEntity getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public void addUser(@RequestBody UserEntity userEntity){
        userService.addUser(userEntity);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
    public void updateUserPassword(@PathVariable long id, @RequestBody UserEntity userEntity){
        userService.updatePassword(id, userEntity);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public void deleteUser(long id){
        userService.deleteUser(id);
    }


}
