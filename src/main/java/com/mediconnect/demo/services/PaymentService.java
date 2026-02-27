package com.mediconnect.demo.services;

import com.mediconnect.demo.entityclasses.Payment;
import com.mediconnect.demo.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService
{
    private final PaymentRepository paymentRepository;

    public Payment processPayment(Double amount) {

        // Simulate random success/failure
        boolean success = Math.random() > 0.2; // 80% success rate

        Payment payment = Payment.builder()
                .amount(amount)
                .paymentStatus(success ? "SUCCESS" : "FAILED")
                .transactionId(UUID.randomUUID().toString())
                .createdAt(LocalDateTime.now())
                .build();

        return paymentRepository.save(payment);
    }

}
