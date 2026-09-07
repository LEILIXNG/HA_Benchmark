package com.habench.customerquote.web;

import com.habench.customerquote.web.RefundTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerquoteController")
public class ShipmentController {

    @GetMapping("/api/customer/quote")
    public String enrich(HttpServletRequest request) {
        String orderNo = request.getHeader("X-Ha-Payload");
        RefundTranslator.collect(orderNo);
        return "ok";
    }
}
