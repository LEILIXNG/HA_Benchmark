package com.habench.vendorapprove.web;

import com.habench.vendorapprove.web.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorapproveController")
public class ReceiptController {

    @GetMapping("/api/vendor/approve")
    public String publish(
            @RequestParam("tag") String tag) {
        PaymentService.resolve(tag);
        return "ok";
    }
}
