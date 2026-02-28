package com.mediconnect.demo.services;

import com.mediconnect.demo.entityclasses.Clinic;
import com.mediconnect.demo.repository.ClinicRepository;
import com.mediconnect.demo.requestDTO.ClinicLoginDTO;
import com.mediconnect.demo.requestDTO.ClinicRequestDTO;
import com.mediconnect.demo.responseDTO.ClinicResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepository clinicRepository;

    @Override
    public ClinicResponseDTO registerClinic(ClinicRequestDTO requestDTO) {

        if (clinicRepository.findByMail(requestDTO.getMail()).isPresent()) {
            return null;
        }

        Clinic clinic = Clinic.builder()
                .hospitalName(requestDTO.getHospitalName())
                .mail(requestDTO.getMail())
                .contactNumber(requestDTO.getContactNumber())
                .address(requestDTO.getAddress())
                .password(requestDTO.getPassword())
                .build();

        Clinic savedClinic = clinicRepository.save(clinic);

        return ClinicResponseDTO.builder()
                .id(savedClinic.getId())
                .hospitalName(savedClinic.getHospitalName())
                .mail(savedClinic.getMail())
                .contactNumber(savedClinic.getContactNumber())
                .address(savedClinic.getAddress())
                .build();
    }

    @Override
    public ClinicResponseDTO loginClinic(ClinicLoginDTO loginDTO) {

        return clinicRepository.findByMail(loginDTO.getMail())
                .filter(clinic -> clinic.getPassword().equals(loginDTO.getPassword()))
                .map(clinic -> ClinicResponseDTO.builder()
                        .id(clinic.getId())
                        .hospitalName(clinic.getHospitalName())
                        .mail(clinic.getMail())
                        .contactNumber(clinic.getContactNumber())
                        .address(clinic.getAddress())
                        .build()
                )
                .orElse(null);
    }
}