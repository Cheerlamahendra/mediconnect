package com.mediconnect.demo.requestDTO;

import lombok.Data;

@Data
public class LoginRequestDTO
{
    private String phoneOrAadhaar;
    private String password;
}
