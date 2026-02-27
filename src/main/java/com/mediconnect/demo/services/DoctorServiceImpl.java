package com.mediconnect.demo.services;

import com.mediconnect.demo.entityclasses.Clinic;
import com.mediconnect.demo.entityclasses.Doctor;
import com.mediconnect.demo.repository.ClinicRepository;
import com.mediconnect.demo.repository.DoctorRepository;
import com.mediconnect.demo.requestDTO.DoctorRequestDTO;
import com.mediconnect.demo.responseDTO.DoctorResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService
{
    private final DoctorRepository doctorRepository;
    private final ClinicRepository clinicRepository;

    @Override
    public DoctorResponseDTO addDoctor(DoctorRequestDTO requestDTO) {

        Clinic clinic = clinicRepository.findById(requestDTO.getClinicId())
                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        Doctor doctor = Doctor.builder()
                .doctorName(requestDTO.getDoctorName())
                .specialization(requestDTO.getSpecialization())
                .experience(requestDTO.getExperience())
                .consultationFee(
                        requestDTO.getConsultationFee() != null
                                ? requestDTO.getConsultationFee()
                                : 100.0
                )
                .clinic(clinic)
                .build();

        Doctor savedDoctor = doctorRepository.save(doctor);

        return DoctorResponseDTO.builder()
                .id(savedDoctor.getId())
                .doctorName(savedDoctor.getDoctorName())
                .specialization(savedDoctor.getSpecialization())
                .experience(savedDoctor.getExperience())
                .consultationFee(savedDoctor.getConsultationFee())
                .build();
    }

    @Override
    public List<DoctorResponseDTO> getDoctorsByClinic(Long clinicId) {

        return doctorRepository.findByClinicId(clinicId)
                .stream()
                .map(doc -> DoctorResponseDTO.builder()
                        .id(doc.getId())
                        .doctorName(doc.getDoctorName())
                        .specialization(doc.getSpecialization())
                        .experience(doc.getExperience())
                        .consultationFee(doc.getConsultationFee())
                        .build())
                .collect(Collectors.toList());
    }
}
