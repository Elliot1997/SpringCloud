package me.lotlog.springcloud.service;

import me.lotlog.springcloud.entites.Payment;


public interface PaymentService {
    Integer create(Payment payment);

    Payment getPaymentById(Long id);
}
