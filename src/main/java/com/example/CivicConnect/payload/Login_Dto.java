package com.example.CivicConnect.payload;

import lombok.Data;

@Data
public class Login_Dto {
    private String id;
    private String email;
    private String password;
}
