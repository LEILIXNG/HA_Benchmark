package com.habench.customercapture.web;

import com.habench.customercapture.web.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customercaptureController")
public class AccountController {

    @GetMapping("/api/customer/capture/{target}")
    public String publish(
            @PathVariable("target") String target) {
        PaymentService.normalize(target);
        return "ok";
    }
}
