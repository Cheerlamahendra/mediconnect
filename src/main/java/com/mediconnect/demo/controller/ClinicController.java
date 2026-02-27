package com.mediconnect.demo.controller;

import com.mediconnect.demo.requestDTO.ClinicLoginDTO;
import com.mediconnect.demo.requestDTO.ClinicRequestDTO;
import com.mediconnect.demo.services.ClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clinic")
@RequiredArgsConstructor
@CrossOrigin(origins = {"${cross.origin.value}", "${cross.origin.localhost.value}"},allowCredentials = "true")
public class ClinicController
{
    private final ClinicService clinicService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerClinic(
            @RequestBody ClinicRequestDTO requestDTO) {

        return ResponseEntity.ok(
                clinicService.registerClinic(requestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> loginClinic(
            @RequestBody ClinicLoginDTO loginDTO) {

        return ResponseEntity.ok(
                clinicService.loginClinic(loginDTO));
    }

}
