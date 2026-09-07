package com.habench.pricingreopen.web;

import com.habench.pricingreopen.web.PaymentEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingreopenController")
public class AccountController {

    @GetMapping("/api/pricing/reopen")
    public String forward(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        PaymentEnricher.prepare(category);
        return "ok";
    }
}
