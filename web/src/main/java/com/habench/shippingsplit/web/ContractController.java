package com.habench.shippingsplit.web;

import com.habench.shippingsplit.web.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingsplitController")
public class ContractController {

    @GetMapping("/api/shipping/split/{reference}")
    public String refine(
            @PathVariable("reference") String reference) {
        OrderService.enrich(reference);
        return "ok";
    }
}
