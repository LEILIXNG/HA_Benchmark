package com.habench.fulfiladjust.web;

import com.habench.fulfiladjust.web.ContractCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfiladjustController")
public class OrderController {

    @GetMapping("/api/fulfil/adjust")
    public String prepare(
            @RequestParam("keyword") String keyword) {
        ContractCoordinator.assemble(keyword);
        return "ok";
    }
}
