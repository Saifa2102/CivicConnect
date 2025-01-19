package com.example.CivicConnect.service;

import com.example.CivicConnect.entity.Register;
import com.example.CivicConnect.exception.ResourceNotFoundException;
import com.example.CivicConnect.payload.Register_Dto;
import com.example.CivicConnect.repository.Register_Repository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegisterService {
    private final Register_Repository registerRepository;
    private final ModelMapper registermodelMapper;

    public RegisterService(Register_Repository registerRepository, ModelMapper registermodelMapper) {
        this.registerRepository = registerRepository;
        this.registermodelMapper = registermodelMapper;
    }


    public List<Register_Dto> getdata() {
        List<Register> registers = registerRepository.findAll();
        List<Register_Dto>registerDtos=registers.stream().map(user->registermodelMapper.map(user,Register_Dto.class)).collect(Collectors.toList());
      return registerDtos;
    }

    public Register_Dto postId(Register_Dto dto) {
        Register postmap = registermodelMapper.map(dto, Register.class);
        Register save = registerRepository.save(postmap);
        Register_Dto mapped = registermodelMapper.map(save, Register_Dto.class);
        return mapped;

    }

    public Register_Dto getid(Long id) {
        Register idNotFound = registerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
        Register_Dto registermap= registermodelMapper.map(idNotFound, Register_Dto.class);
        return registermap;
    }


}
