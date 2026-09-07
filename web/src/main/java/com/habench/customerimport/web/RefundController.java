package com.habench.customerimport.web;

import com.habench.customerimport.web.PaymentCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerimportController")
public class RefundController {

    @GetMapping("/api/customer/import")
    public String merge(HttpServletRequest request) {
        String keyword = request.getHeader("X-Ha-Payload");
        PaymentCollector.expand(keyword);
        return "ok";
    }
}
