package com.example.CivicConnect.controller;

import com.example.CivicConnect.payload.Login_Dto;
import com.example.CivicConnect.service.Login_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Login")
public class Login_Controller {
    private final Login_Service loginService;

    public Login_Controller( Login_Service loginService){
        this.loginService = loginService;
    }
    @PostMapping(path = "/Log")
    public ResponseEntity<Login_Dto> entity(@RequestBody Login_Dto dto)
    {
        Login_Dto dto1=loginService.login1(dto);
        return new ResponseEntity<>(dto1, HttpStatus.CREATED);
    }


}
