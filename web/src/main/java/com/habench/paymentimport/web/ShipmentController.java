package com.habench.paymentimport.web;

import com.habench.paymentimport.web.BatchNormalizer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentimportController")
public class ShipmentController {

    @GetMapping("/api/payment/import")
    public String refine(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        BatchNormalizer.translate(tag);
        return "ok";
    }
}
