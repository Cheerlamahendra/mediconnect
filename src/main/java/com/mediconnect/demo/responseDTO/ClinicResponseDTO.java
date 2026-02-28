package com.mediconnect.demo.responseDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClinicResponseDTO
{
    private Long id;
    private String hospitalName;
    private String mail;
    private String contactNumber;
    private String address;
}
