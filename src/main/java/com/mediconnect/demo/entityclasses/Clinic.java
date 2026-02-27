package com.mediconnect.demo.entityclasses;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clinics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clinic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String hospitalName;

    @Column(unique = true)
    private String mail;

    @Column(unique = true)
    private String contactNumber;

    private String address;

    private String password;
}
