package com.habench.orderposting.web;

import com.habench.orderposting.web.ContractCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderpostingController")
public class OrderController {

    @GetMapping("/api/order/posting")
    public String attach(
            @RequestParam("query") String query) {
        ContractCoordinator.translate(query);
        return "ok";
    }
}
