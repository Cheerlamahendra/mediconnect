package com.mediconnect.demo.services;

import com.mediconnect.demo.requestDTO.DoctorRequestDTO;
import com.mediconnect.demo.responseDTO.DoctorResponseDTO;

import java.util.List;

public interface DoctorService
{
    DoctorResponseDTO addDoctor(DoctorRequestDTO requestDTO);

    List<DoctorResponseDTO> getDoctorsByClinic(Long clinicId);
}
