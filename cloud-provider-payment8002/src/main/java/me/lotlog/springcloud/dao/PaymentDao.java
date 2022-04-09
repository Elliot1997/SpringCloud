package me.lotlog.springcloud.dao;

import me.lotlog.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    Integer create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
