package com.mediconnect.demo.services;

import com.mediconnect.demo.requestDTO.ClinicLoginDTO;
import com.mediconnect.demo.requestDTO.ClinicRequestDTO;

public interface ClinicService
{
    boolean registerClinic(ClinicRequestDTO requestDTO);

    boolean loginClinic(ClinicLoginDTO loginDTO);
}
