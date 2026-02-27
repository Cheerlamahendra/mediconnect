package com.mediconnect.demo.controller;

import com.mediconnect.demo.requestDTO.LoginRequestDTO;
import com.mediconnect.demo.responseDTO.PatientResponseDTO;
import com.mediconnect.demo.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
//@CrossOrigin(origins = {"${cross.origin.value}", "${cross.origin.localhost.value}"},allowCredentials = "true")
@CrossOrigin(origins = "${cross.origin.value}")
public class login {

    private final PatientService patientService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {

        PatientResponseDTO response = patientService.login(dto);

        if (response == null) {
            return ResponseEntity
                    .status(401)
                    .body(false);   // login failed
        }

        return ResponseEntity.ok(response);
    }
}