package com.habench.customerrefund.web;

import com.habench.customerrefund.web.RefundService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerrefundController")
public class TariffController {

    @GetMapping("/api/customer/refund/{filename}")
    public String merge(
            @PathVariable("filename") String filename) {
        RefundService.register(filename);
        return "ok";
    }
}
