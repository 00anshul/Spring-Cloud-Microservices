package com.order_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private PaymentServiceFeignClient paymentClient;

	@GetMapping("/options")
	public List<String> options() {
		return paymentClient.getPaymentOptions();
	}
}