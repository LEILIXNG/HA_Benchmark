package com.habench.customerhold.web;

import com.habench.customerhold.web.LedgerCoordinator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerholdController")
public class QuoteController {

    @GetMapping("/api/customer/hold")
    public String forward(HttpServletRequest request) {
        String label = request.getHeader("X-Ha-Payload");
        LedgerCoordinator.attach(label);
        return "ok";
    }
}
