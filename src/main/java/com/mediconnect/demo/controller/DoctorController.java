package com.mediconnect.demo.controller;

import com.mediconnect.demo.requestDTO.DoctorRequestDTO;
import com.mediconnect.demo.responseDTO.DoctorResponseDTO;
import com.mediconnect.demo.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
//@CrossOrigin(origins="${cross.origin.value}")
public class DoctorController
{
    private final DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<DoctorResponseDTO> addDoctor(
            @RequestBody DoctorRequestDTO requestDTO) {

        return ResponseEntity.ok(
                doctorService.addDoctor(requestDTO)
        );
    }

    @GetMapping("/clinic/{clinicId}")
    public ResponseEntity<List<DoctorResponseDTO>> getDoctorsByClinic(
            @PathVariable Long clinicId) {

        return ResponseEntity.ok(
                doctorService.getDoctorsByClinic(clinicId)
        );
    }

}
