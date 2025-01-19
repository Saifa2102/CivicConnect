package com.example.CivicConnect.service;

import com.example.CivicConnect.entity.Login;
import com.example.CivicConnect.payload.Login_Dto;
import com.example.CivicConnect.repository.Login_Repository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class Login_Service {
    private final Login_Repository loginRepository;
    private final ModelMapper loginmodelMapper;

    public Login_Service(Login_Repository loginRepository, ModelMapper loginmodelMapper) {
        this.loginRepository = loginRepository;
        this.loginmodelMapper = loginmodelMapper;
    }

    public Login_Dto login1(Login_Dto dto) {

        Login map = loginmodelMapper.map(dto, Login.class);
        Login save = loginRepository.save(map);
        Login_Dto mapped = loginmodelMapper.map(save, Login_Dto.class);
        return mapped;

    }


}
