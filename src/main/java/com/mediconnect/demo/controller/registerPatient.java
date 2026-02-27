package com.mediconnect.demo.controller;

import com.mediconnect.demo.requestDTO.PatientRequestDTO;
import com.mediconnect.demo.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
//@CrossOrigin(origins = {"${cross.origin.value}", "${cross.origin.localhost.value}"},allowCredentials = "true")
@CrossOrigin(origins="${cross.origin.value}")
public class registerPatient
{
    private final PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerPatient(
            @RequestBody PatientRequestDTO requestDTO) {

        boolean result = patientService.registerPatient(requestDTO);

        return ResponseEntity.ok(result);
    }

}
