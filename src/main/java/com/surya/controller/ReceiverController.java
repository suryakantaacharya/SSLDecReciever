package com.surya.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiverController {

	@PostMapping(value = "/decrypt")
	public String decrytion(@RequestBody Object obj) {
		System.out.println(obj.toString());
		return "OK";
	}
	
}
