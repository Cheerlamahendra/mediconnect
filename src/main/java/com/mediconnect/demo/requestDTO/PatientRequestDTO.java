package com.mediconnect.demo.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequestDTO
{
    private String name;
    private String phoneNumber;
    private String email;
    private String aadhaarNumber;
    private String gender;
    private Integer age;
    private String address;
    private String bloodGroup;
    private String password;
}
