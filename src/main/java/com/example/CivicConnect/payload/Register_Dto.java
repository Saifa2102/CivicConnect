package com.example.CivicConnect.payload;

import lombok.Data;

@Data
public class Register_Dto {
    private Long id;
    private String name;
    private String address;
    private String number;
    private String email;
    private String password;
}
