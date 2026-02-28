package com.mediconnect.demo.services;

import com.mediconnect.demo.requestDTO.ClinicLoginDTO;
import com.mediconnect.demo.requestDTO.ClinicRequestDTO;
import com.mediconnect.demo.responseDTO.ClinicResponseDTO;

public interface ClinicService {

    ClinicResponseDTO registerClinic(ClinicRequestDTO requestDTO);

    ClinicResponseDTO loginClinic(ClinicLoginDTO loginDTO);
}