package com.fishdemon.msk.consumer.controller;

import com.fishdemon.msk.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;

	@GetMapping
	public String hello() {
		return consumerService.hello();
	}
	
	@GetMapping("/{id}")
	public String getById(@PathVariable("id") String id) {
		return consumerService.getById(id);
	}
	
	@GetMapping("/user")
	public String getByName(@RequestParam("name") String name) {
		return consumerService.getByName(name);
	}
	
}
