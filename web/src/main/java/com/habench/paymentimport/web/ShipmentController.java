package com.habench.paymentimport.web;

import com.habench.paymentimport.web.QuoteAssembler;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentimportController")
public class ShipmentController {

    @GetMapping("/api/payment/import")
    public String merge(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        QuoteAssembler.collect(token);
        return "ok";
    }
}
