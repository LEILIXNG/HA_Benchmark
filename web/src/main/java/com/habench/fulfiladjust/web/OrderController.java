package com.habench.fulfiladjust.web;

import com.habench.fulfiladjust.web.VoucherCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfiladjustController")
public class OrderController {

    @GetMapping("/api/fulfil/adjust")
    public String attach(
            @RequestParam("tag") String tag) {
        VoucherCoordinator.reconcile(tag);
        return "ok";
    }
}
