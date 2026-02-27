package com.mediconnect.demo.services;

import com.mediconnect.demo.entityclasses.Clinic;
import com.mediconnect.demo.repository.ClinicRepository;
import com.mediconnect.demo.requestDTO.ClinicLoginDTO;
import com.mediconnect.demo.requestDTO.ClinicRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClinicServiceImpl implements ClinicService
{
    private final ClinicRepository clinicRepository;

    @Override
    public boolean registerClinic(ClinicRequestDTO requestDTO) {

        if (clinicRepository.findByMail(requestDTO.getMail()).isPresent()) {
            return false;
        }

        Clinic clinic = Clinic.builder()
                .hospitalName(requestDTO.getHospitalName())
                .mail(requestDTO.getMail())
                .contactNumber(requestDTO.getContactNumber())
                .address(requestDTO.getAddress())
                .password(requestDTO.getPassword())
                .build();

        clinicRepository.save(clinic);

        return true;
    }

    @Override
    public boolean loginClinic(ClinicLoginDTO loginDTO) {

        return clinicRepository.findByMail(loginDTO.getMail())
                .map(clinic -> clinic.getPassword().equals(loginDTO.getPassword()))
                .orElse(false);
    }

}
