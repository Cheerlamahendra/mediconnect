package com.mediconnect.demo.services;


import com.mediconnect.demo.entityclasses.Patient;
import com.mediconnect.demo.repository.PatientRepository;
import com.mediconnect.demo.requestDTO.LoginRequestDTO;
import com.mediconnect.demo.requestDTO.PatientRequestDTO;
import com.mediconnect.demo.responseDTO.PatientResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService
{
    private final PatientRepository patientRepository;

    // ✅ REGISTER
    @Override
    public boolean registerPatient(PatientRequestDTO requestDTO) {

        Optional<Patient> existingPatient =
                patientRepository.findByAadhaarNumber(requestDTO.getAadhaarNumber());

        if (existingPatient.isPresent()) {
            return false; // Patient already exists
        }
        // Check Email
        if (patientRepository
                .findByEmail(requestDTO.getEmail())
                .isPresent()) {
            return false;
        }

        Patient patient = Patient.builder()
                .name(requestDTO.getName())
                .phoneNumber(requestDTO.getPhoneNumber())
                .email(requestDTO.getEmail())
                .aadhaarNumber(requestDTO.getAadhaarNumber())
                .gender(requestDTO.getGender())
                .age(requestDTO.getAge())
                .address(requestDTO.getAddress())
                .bloodGroup(requestDTO.getBloodGroup())
                .password(requestDTO.getPassword())
                .build();

        patientRepository.save(patient);

        return true; // Successfully registered
    }

    // ✅ LOGIN (Phone OR Aadhaar)
    @Override
    public PatientResponseDTO login(LoginRequestDTO loginRequestDTO) {

        String input = loginRequestDTO.getPhoneOrAadhaar();

        Optional<Patient> patientOptional =
                patientRepository.findByPhoneNumber(input);

        if (patientOptional.isEmpty()) {
            patientOptional =
                    patientRepository.findByAadhaarNumber(input);
        }

        if (patientOptional.isPresent()) {

            Patient patient = patientOptional.get();

            if (patient.getPassword()
                    .equals(loginRequestDTO.getPassword())) {

                return PatientResponseDTO.builder()
                        .id(patient.getId())
                        .name(patient.getName())
                        .phoneNumber(patient.getPhoneNumber())
                        .email(patient.getEmail())
                        .aadhaarNumber(patient.getAadhaarNumber())
                        .gender(patient.getGender())
                        .age(patient.getAge())
                        .address(patient.getAddress())
                        .bloodGroup(patient.getBloodGroup())
                        .build();
            }
        }

        return null;
    }// ✅ login failed
    }
