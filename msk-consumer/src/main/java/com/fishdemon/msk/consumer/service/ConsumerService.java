package com.fishdemon.msk.consumer.service;

import com.fishdemon.msk.consumer.service.fallback.ConsumerServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="msk-provider", fallback = ConsumerServiceFallback.class)
public interface ConsumerService {
	
	@GetMapping("/provider/hello")
	String hello();
	
	@GetMapping("/provider/hello/{id}")
	String getById(@PathVariable("id") String id);
	
	@GetMapping("/provider/hello/user")
	String getByName(@RequestParam("name") String name);
	
}
