package com.example.CivicConnect.payload;

import lombok.Data;

@Data
public class Report_Issue_Dto {
    private Long id;
    private String name;
    private String email;
    private String number;
    private String address;
    private String issuetype;
    private String urgency;
    private String description;

}
