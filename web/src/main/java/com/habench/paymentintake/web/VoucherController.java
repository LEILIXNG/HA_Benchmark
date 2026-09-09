package com.habench.paymentintake.web;

import com.habench.paymentintake.web.ManifestCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentintakeController")
public class VoucherController {

    @GetMapping("/api/payment/intake")
    public String enrich(
            @RequestParam("userName") String userName) {
        ManifestCoordinator.assemble(userName);
        return "ok";
    }
}
