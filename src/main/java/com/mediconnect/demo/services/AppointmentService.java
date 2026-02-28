package com.mediconnect.demo.services;

import com.mediconnect.demo.entityclasses.Appointment;
import com.mediconnect.demo.requestDTO.AppointmentRequestDTO;
import com.mediconnect.demo.responseDTO.AppointmentResponseDTO;

import java.util.List;

public interface AppointmentService
{
    AppointmentResponseDTO bookAppointment(AppointmentRequestDTO requestDTO);
    List<Appointment> getAppointmentsByPatientId(int patientId);

    List<Appointment> getAppointmentsByClinicId(int clinicId);
    List<Appointment> getAppointmentsByDoctorId(int doctorId);
}
