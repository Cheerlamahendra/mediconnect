package com.mediconnect.demo.repository;

import com.mediconnect.demo.entityclasses.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>
{
    boolean existsByDoctorIdAndAppointmentDateAndStartTime(
            Long doctorId,
            LocalDate appointmentDate,
            LocalTime startTime
    );
    List<Appointment> findByPatientId(int patientId);

    List<Appointment> findByClinicId(int clinicId);
    List<Appointment> findByDoctorId(int doctorId);
}
