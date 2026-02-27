package com.mediconnect.demo.controller;

import com.mediconnect.demo.requestDTO.AppointmentRequestDTO;
import com.mediconnect.demo.responseDTO.AppointmentResponseDTO;
import com.mediconnect.demo.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
//@CrossOrigin(origins = {"${cross.origin.value}", "${cross.origin.localhost.value}"},allowCredentials = "true")
@CrossOrigin(origins="${cross.origin.value}")
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

}
