package com.habench.billinghold.web;

import com.habench.billinghold.web.TariffEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingholdController")
public class ReceiptController {

    @GetMapping("/api/billing/hold")
    public String reconcile(HttpServletRequest request) {
        String userName = request.getHeader("X-Ha-Payload");
        TariffEnricher.translate(userName);
        return "ok";
    }
}
