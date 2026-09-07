package com.habench.customerrefund.web;

import com.habench.customerrefund.web.SessionCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerrefundController")
public class TariffController {

    @GetMapping("/api/customer/refund")
    public String stage(HttpServletRequest request) {
        String filename = request.getHeader("X-Ha-Payload");
        SessionCollector.translate(filename);
        return "ok";
    }
}
