package com.mediconnect.demo.repository;

import com.mediconnect.demo.entityclasses.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository  extends JpaRepository<Patient, Long>
{
    Optional<Patient> findByPhoneNumber(String phoneNumber);
    Optional<Patient> findByAadhaarNumber(String aadhaarNumber);
    Optional<Patient> findByEmail(String email);
}
