package com.mediconnect.demo.requestDTO;

import lombok.Data;

@Data
public class DoctorRequestDTO
{
    private String doctorName;
    private String specialization;
    private Integer experience;
    private Double consultationFee;
    private Long clinicId;
}
