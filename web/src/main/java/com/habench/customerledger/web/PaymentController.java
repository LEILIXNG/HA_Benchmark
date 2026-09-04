package com.habench.customerledger.web;

import com.habench.customerledger.web.TariffBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerledgerController")
public class PaymentController {

    @GetMapping("/api/customer/ledger")
    public String stage(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        TariffBuilder.merge(token);
        return "ok";
    }
}
