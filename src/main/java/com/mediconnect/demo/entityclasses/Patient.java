package com.mediconnect.demo.entityclasses;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)   //  Unique Aadhaar
    private String aadhaarNumber;

    private String gender;

    private Integer age;

    private String address;

    private String bloodGroup;

    private String password;

}
