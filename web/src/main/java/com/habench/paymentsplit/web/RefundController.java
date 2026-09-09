package com.habench.paymentsplit.web;

import com.habench.paymentsplit.web.TariffBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentsplitController")
public class RefundController {

    @GetMapping("/api/payment/split")
    public String route(HttpServletRequest request) {
        String token = request.getHeader("X-Refund-Context");
        TariffBuilder.stage(token);
        return "ok";
    }
}
