package com.payment_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	@GetMapping("/options")
	public List<String> paymentOption() {
		return List.of("UPI", "NetBanking", "CreditCard", "DebitCard");
	}
}
