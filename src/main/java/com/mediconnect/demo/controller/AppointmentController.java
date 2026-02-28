package com.mediconnect.demo.controller;

import com.mediconnect.demo.entityclasses.Appointment;
import com.mediconnect.demo.requestDTO.AppointmentRequestDTO;
import com.mediconnect.demo.responseDTO.AppointmentResponseDTO;
import com.mediconnect.demo.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
//@CrossOrigin(origins = {"${cross.origin.value}", "${cross.origin.localhost.value}"},allowCredentials = "true")
//@CrossOrigin(origins="${cross.origin.value}")
public class AppointmentController
{
    private final AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<AppointmentResponseDTO> bookAppointment(
            @RequestBody AppointmentRequestDTO requestDTO) {

        return ResponseEntity.ok(
                appointmentService.bookAppointment(requestDTO)
        );
    }
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatient(
            @PathVariable int patientId) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsByPatientId(patientId)
        );
    }

    @GetMapping("/clinic/{clinicId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByClinic(
            @PathVariable int clinicId) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsByClinicId(clinicId)
        );
    }
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctor(
            @PathVariable int doctorId) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsByDoctorId(doctorId)
        );
    }
    @GetMapping("/test")
    public String test() {
        return "Appointments Controller Working";
    }

}
