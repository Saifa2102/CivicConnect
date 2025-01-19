package com.example.CivicConnect.service;

import com.example.CivicConnect.entity.Report_Issue;
import com.example.CivicConnect.payload.Report_Issue_Dto;
import com.example.CivicConnect.repository.Report_Issue_Repository;
import com.example.CivicConnect.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Report_Issue_Service {
    private final Report_Issue_Repository reportIssueRepository;
    private final ModelMapper modelMapper;

    public Report_Issue_Service(Report_Issue_Repository userRepository, ModelMapper modelMapper) {
        this.reportIssueRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Report_Issue_Dto signup(Report_Issue_Dto signUpDto) {
        Report_Issue entity = modelMapper.map(signUpDto, Report_Issue.class);
        Report_Issue save = reportIssueRepository.save(entity);
        Report_Issue_Dto dto = modelMapper.map(save, Report_Issue_Dto.class);
        return dto;

    }
    public List<Report_Issue_Dto> allData()
    {

        List<Report_Issue> all = reportIssueRepository.findAll();
        List<Report_Issue_Dto> upDtos = all.stream().map(user -> modelMapper.map(user, Report_Issue_Dto.class)).collect(Collectors.toList());
        return upDtos;

    }


    public Report_Issue_Dto byid(Long id) {

        Report_Issue data = reportIssueRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id not found"));
        Report_Issue_Dto mapped = modelMapper.map(data, Report_Issue_Dto.class);
        return mapped;
    }

    public Report_Issue_Dto update(Long id, Report_Issue_Dto signUpDto) {
        Optional<Report_Issue> byId = reportIssueRepository.findById(id);
        if (byId.isPresent()){
            Report_Issue user = byId.get();
            Report_Issue map = modelMapper.map(signUpDto, Report_Issue.class);
            Report_Issue save = reportIssueRepository.save(map);
            Report_Issue_Dto map1 = modelMapper.map(save, Report_Issue_Dto.class);

            return map1;
        }
    else {
        throw new ResourceNotFoundException("id not found");

        }

    }


}


