package com.mediconnect.demo.repository;

import com.mediconnect.demo.entityclasses.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>
{
    
}
