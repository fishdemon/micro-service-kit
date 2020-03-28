package com.fishdemon.msk.consumer.service.fallback;

import com.fishdemon.msk.consumer.service.ConsumerService;
import org.springframework.stereotype.Component;

@Component
public class ConsumerServiceFallback implements ConsumerService {

    @Override
    public String hello() {
        return "error request: provider service is down";
    }

    @Override
    public String getById(String id) {
        return "error request: provider service is down";
    }

    @Override
    public String getByName(String name) {
        return "error request: provider service is down";
    }
}
