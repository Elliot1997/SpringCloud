package me.lotlog.springcloud.controller;

import me.lotlog.springcloud.entites.CommonResult;
import me.lotlog.springcloud.entites.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/order")
public class OrderController {

    public static final String PAYMENT_SRC_URL = "http://CLOUD-PAYMENT-SERVICE:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/create")
    public CommonResult<?> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_SRC_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/query/{id}")
    public CommonResult<?> getPayment(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_SRC_URL + "/payment/query/"+id, CommonResult.class,id);
    }
}
