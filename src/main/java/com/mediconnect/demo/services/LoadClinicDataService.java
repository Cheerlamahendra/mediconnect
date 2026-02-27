package com.mediconnect.demo.services;

import com.mediconnect.demo.entityclasses.Clinic;
import com.mediconnect.demo.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadClinicDataService
{
    @Autowired
    private ClinicRepository clinicRepository;
    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

}
