package com.mediconnect.demo.requestDTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentRequestDTO
{
    private Long patientId;
    private Long clinicId;
    private Long doctorId;

    private LocalDate appointmentDate;
    private LocalTime startTime;
}
