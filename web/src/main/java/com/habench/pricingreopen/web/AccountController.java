package com.habench.pricingreopen.web;

import com.habench.pricingreopen.web.PaymentRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreopenController")
public class AccountController {

    @GetMapping("/api/pricing/reopen")
    public String forward(
            @RequestParam("resource") String resource) {
        PaymentRegistry.forward(resource);
        return "ok";
    }
}
