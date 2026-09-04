package com.habench.customersplit.web;

import com.habench.customersplit.web.ContractEnricher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("customersplitController")
public class OrderController {

    @GetMapping("/api/customer/split")
    public String publish(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        ContractEnricher.submit(token);
        return "ok";
    }
}
