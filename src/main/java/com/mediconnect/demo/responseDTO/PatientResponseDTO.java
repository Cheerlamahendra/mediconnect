package com.mediconnect.demo.responseDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponseDTO
{
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String aadhaarNumber;
    private String gender;
    private Integer age;
    private String address;
    private String bloodGroup;
}
