package com.mediconnect.demo.controller;

import com.mediconnect.demo.requestDTO.ClinicLoginDTO;
import com.mediconnect.demo.requestDTO.ClinicRequestDTO;
import com.mediconnect.demo.responseDTO.ClinicResponseDTO;
import com.mediconnect.demo.services.ClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clinic")
@RequiredArgsConstructor
//@CrossOrigin(origins = {"${cross.origin.value}", "${cross.origin.localhost.value}"}, allowCredentials = "true")
public class ClinicController {

    private final ClinicService clinicService;

    @PostMapping("/register")
    public ResponseEntity<?> registerClinic(
            @RequestBody ClinicRequestDTO requestDTO) {

        ClinicResponseDTO response = clinicService.registerClinic(requestDTO);

        if (response == null) {
            return ResponseEntity.badRequest().body("Clinic already exists");
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginClinic(
            @RequestBody ClinicLoginDTO loginDTO) {

        ClinicResponseDTO response = clinicService.loginClinic(loginDTO);

        if (response == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        return ResponseEntity.ok(response);
    }
}