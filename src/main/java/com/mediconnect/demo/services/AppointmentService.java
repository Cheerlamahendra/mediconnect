package com.mediconnect.demo.services;

import com.mediconnect.demo.requestDTO.AppointmentRequestDTO;
import com.mediconnect.demo.responseDTO.AppointmentResponseDTO;

public interface AppointmentService
{
    AppointmentResponseDTO bookAppointment(AppointmentRequestDTO requestDTO);
}
