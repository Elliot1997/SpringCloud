package me.lotlog.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import me.lotlog.springcloud.entites.CommonResult;
import me.lotlog.springcloud.entites.Payment;
import me.lotlog.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        Integer resultCode = paymentService.create(payment);
        if (resultCode > 0){
            return new CommonResult<>(200,"插入订单成功,id为:"+payment.getId()+port,payment);
        }else {
            return new CommonResult<>(500,"插入订单失败");
        }
    }

    @GetMapping ("/query/{id}")
    public CommonResult<Payment> query(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null){
            log.info("测试"+payment.getId()+":"+payment.getSerial());
            return new CommonResult<>(200, "查询成功"+port, payment);
        }else {
            return new CommonResult<>(500, "未查询到id为"+id+"相关信息!");
        }
    }
}
