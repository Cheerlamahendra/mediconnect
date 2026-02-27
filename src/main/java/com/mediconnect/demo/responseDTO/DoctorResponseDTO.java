package com.mediconnect.demo.responseDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponseDTO
{
    private Long id;
    private String doctorName;
    private String specialization;
    private Integer experience;
    private Double consultationFee;

}
