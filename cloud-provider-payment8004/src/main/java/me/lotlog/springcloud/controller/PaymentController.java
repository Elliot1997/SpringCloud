package me.lotlog.springcloud.controller;

import me.lotlog.springcloud.entites.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;
import java.util.UUID;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/zk/payment")
    public CommonResult<?> payment() {
        return new CommonResult<>(500, "端口:" + port + UUID.randomUUID().toString(), null);
    }
}
