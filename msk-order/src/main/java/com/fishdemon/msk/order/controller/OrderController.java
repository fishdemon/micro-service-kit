package com.fishdemon.msk.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @GetMapping
    public List<String> getOrders() {
        List<String> orders = new ArrayList<String>(){
            {
                this.add("order1");
                this.add("order2");
                this.add("order3");
            }
        };
        return orders;
    }

}
