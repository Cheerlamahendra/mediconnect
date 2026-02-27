package com.mediconnect.demo.repository;

import com.mediconnect.demo.entityclasses.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClinicRepository extends JpaRepository<Clinic, Long>
{
    Optional<Clinic> findByMail(String mail);

}
