package com.habench.billingmerge.web;

import com.habench.billingmerge.web.TariffResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingmergeController")
public class ShipmentController {

    @GetMapping("/api/billing/merge")
    public String forward(
            @RequestParam("keyword") String keyword) {
        TariffResolver.compose(keyword);
        return "ok";
    }
}
