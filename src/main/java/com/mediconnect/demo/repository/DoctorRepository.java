package com.mediconnect.demo.repository;

import com.mediconnect.demo.entityclasses.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long>
{
    List<Doctor> findByClinicId(Long clinicId);
}
