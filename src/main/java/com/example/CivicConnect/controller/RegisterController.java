package com.example.CivicConnect.controller;

import com.example.CivicConnect.payload.Register_Dto;
import com.example.CivicConnect.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Register")
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @PostMapping(path = "/postregister")
    public ResponseEntity<Register_Dto> post(@RequestBody Register_Dto dto)
    {
        Register_Dto registerDto = registerService.postId(dto);
        return new ResponseEntity<>(registerDto, HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAllData")
    public ResponseEntity<List<Register_Dto>> FetchAllid()
    {
        List<Register_Dto> registerDtos =registerService.getdata();
        return new ResponseEntity<>(registerDtos, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Register_Dto> FetchById(@PathVariable Long id)
    {
        Register_Dto registerDto = registerService.getid(id);
        return new ResponseEntity<>(registerDto, HttpStatus.OK);
    }


}
