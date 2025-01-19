package com.example.CivicConnect.controller;

import com.example.CivicConnect.payload.Report_Issue_Dto;
import com.example.CivicConnect.service.Report_Issue_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/App")
public class Report_Issue_Controller {

    private final Report_Issue_Service reportIssueService;

    public Report_Issue_Controller(Report_Issue_Service userService) {
        this.reportIssueService = userService;
    }

    @PostMapping (path = "/SignUp")
    public ResponseEntity<Report_Issue_Dto> signUp(@RequestBody Report_Issue_Dto signUpDto)
    {
        Report_Issue_Dto signup = reportIssueService.signup(signUpDto);
        return new ResponseEntity<>(signup, HttpStatus.CREATED);


    }

    @GetMapping(path = "/getAllData")
    public ResponseEntity<List<Report_Issue_Dto>> FetchAllData()
    {
        List<Report_Issue_Dto> signUpDtos = reportIssueService.allData();
        return new ResponseEntity<>(signUpDtos, HttpStatus.OK);

    }

    @GetMapping(path  ="{id}")
    public ResponseEntity<Report_Issue_Dto> FetchById(@PathVariable Long id)
    {
        Report_Issue_Dto byid = reportIssueService.byid(id);
        return new ResponseEntity<>(byid , HttpStatus.OK);
    }

 @PutMapping("/{id}")
    public ResponseEntity<Report_Issue_Dto> sign (@PathVariable Long id, @RequestBody Report_Issue_Dto signUpDto)
 {
     Report_Issue_Dto sign = reportIssueService.update(id , signUpDto);
     return new ResponseEntity<>(sign , HttpStatus.OK);
 }



}


