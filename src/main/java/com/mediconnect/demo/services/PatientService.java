package com.mediconnect.demo.services;


import com.mediconnect.demo.requestDTO.LoginRequestDTO;
import com.mediconnect.demo.requestDTO.PatientRequestDTO;
import com.mediconnect.demo.responseDTO.PatientResponseDTO;


public interface PatientService
{
    PatientResponseDTO login(LoginRequestDTO loginRequestDTO);
    boolean registerPatient(PatientRequestDTO requestDTO);
}
