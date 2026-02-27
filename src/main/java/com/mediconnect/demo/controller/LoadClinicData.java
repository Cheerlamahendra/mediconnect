package com.mediconnect.demo.controller;

import com.mediconnect.demo.entityclasses.Clinic;
import com.mediconnect.demo.repository.ClinicRepository;
import com.mediconnect.demo.services.LoadClinicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"${cross.origin.value}", "${cross.origin.localhost.value}"},allowCredentials = "true")
@CrossOrigin(origins = "${cross.origin.value}")
public class LoadClinicData
{
    @Autowired
    private LoadClinicDataService loadClinicDataService;
    @GetMapping("/all")
    public ResponseEntity<List<Clinic>> getAllClinics() {
        return ResponseEntity.ok(loadClinicDataService.getAllClinics());
    }

}
