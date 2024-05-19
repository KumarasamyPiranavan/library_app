package com.user.library.controller;

import com.user.library.DTO.UserDTO;
import com.user.library.DTO.UserSaveDTO;

import com.user.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String addUser(@RequestBody UserSaveDTO userSaveDTO){

        String id = userService.addUser(userSaveDTO);
        return id;
    }

    @GetMapping("/all")
    public List<UserDTO> getAllUser(){
        List<UserDTO> allUsers = userService.getAllUser();
        return allUsers;
    }
}
