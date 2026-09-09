package com.habench.pricinghold.web;

import com.habench.pricinghold.web.ChannelCoordinator;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingholdController")
public class VoucherController {

    @GetMapping("/api/pricing/hold")
    public String refine(
            @CookieValue("voucher_ref") String label) {
        ChannelCoordinator.register(label);
        return "ok";
    }
}
