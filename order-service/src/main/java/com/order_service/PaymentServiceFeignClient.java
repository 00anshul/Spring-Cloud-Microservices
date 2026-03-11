package com.order_service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("payment-service")
public interface PaymentServiceFeignClient {
	 @GetMapping("/payment/options")
	    List<String> getPaymentOptions();

}
