package com.mediconnect.demo.services;

import com.mediconnect.demo.entityclasses.*;
import com.mediconnect.demo.repository.*;
import com.mediconnect.demo.requestDTO.AppointmentRequestDTO;
import com.mediconnect.demo.responseDTO.AppointmentResponseDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final ClinicRepository clinicRepository;
    private final DoctorRepository doctorRepository;
    private final PaymentService paymentService;

    @Override
    public AppointmentResponseDTO bookAppointment(AppointmentRequestDTO requestDTO) {

        // 🔥 1️⃣ Check slot availability
        boolean slotExists = appointmentRepository
                .existsByDoctorIdAndAppointmentDateAndStartTime(
                        requestDTO.getDoctorId(),
                        requestDTO.getAppointmentDate(),
                        requestDTO.getStartTime()
                );

        if (slotExists) {
            return AppointmentResponseDTO.builder()
                    .message("Slot already booked")
                    .appointmentStatus("FAILED")
                    .build();
        }

        // 🔥 2️⃣ Fetch required entities
        Patient patient = patientRepository.findById(requestDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Clinic clinic = clinicRepository.findById(requestDTO.getClinicId())
                .orElseThrow(() -> new RuntimeException("Clinic not found"));

        Doctor doctor = doctorRepository.findById(requestDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        // 🔥 3️⃣ Create Appointment
        LocalTime endTime = requestDTO.getStartTime().plusMinutes(10);

        Appointment appointment = Appointment.builder()
                .appointmentDate(requestDTO.getAppointmentDate())
                .startTime(requestDTO.getStartTime())
                .endTime(endTime)
                .amount(100.0)
                .paymentStatus("PENDING")
                .appointmentStatus("PENDING")
                .createdAt(LocalDateTime.now())
                .patient(patient)
                .clinic(clinic)
                .doctor(doctor)
                .build();

        Appointment savedAppointment = appointmentRepository.save(appointment);

        // 🔥 4️⃣ Process Payment
        Payment payment = paymentService.processPayment(100.0);

        savedAppointment.setPaymentStatus(payment.getPaymentStatus());

        if (payment.getPaymentStatus().equals("SUCCESS")) {
            savedAppointment.setAppointmentStatus("CONFIRMED");
        } else {
            savedAppointment.setAppointmentStatus("CANCELLED");
        }

        appointmentRepository.save(savedAppointment);

        return AppointmentResponseDTO.builder()
                .appointmentId(savedAppointment.getId())
                .appointmentDate(savedAppointment.getAppointmentDate())
                .startTime(savedAppointment.getStartTime())
                .endTime(savedAppointment.getEndTime())
                .appointmentStatus(savedAppointment.getAppointmentStatus())
                .paymentStatus(savedAppointment.getPaymentStatus())
                .message("Appointment processed")
                .build();
    }
}