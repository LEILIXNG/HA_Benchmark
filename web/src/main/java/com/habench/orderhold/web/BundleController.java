package com.habench.orderhold.web;

import com.habench.orderhold.web.VoucherBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderholdController")
public class BundleController {

    @GetMapping("/api/order/hold")
    public String reconcile(
            @RequestParam("token") String token) {
        VoucherBuilder.enrich(token);
        return "ok";
    }
}
