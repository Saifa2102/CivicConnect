package com.example.CivicConnect.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="Customer_Details")
public class Report_Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Username cannot be null")
    @Size(max = 10, min=3)
    private String name;
    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
    private String number;
    private String address;
    private String issuetype;
    private String urgency;
    private String description;


}
