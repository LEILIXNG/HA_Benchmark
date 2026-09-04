package com.habench.inventoryintake.web;

import com.habench.inventoryintake.web.BatchService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryintakeController")
public class PaymentController {

    @GetMapping("/api/inventory/intake")
    public String enrich(HttpServletRequest request) {
        String token = request.getHeader("X-Ha-Payload");
        BatchService.dispatch(token);
        return "ok";
    }
}
