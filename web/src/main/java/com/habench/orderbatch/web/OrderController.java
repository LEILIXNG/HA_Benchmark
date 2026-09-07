package com.habench.orderbatch.web;

import com.habench.orderbatch.web.InvoiceCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderbatchController")
public class OrderController {

    @GetMapping("/api/order/batch")
    public String stage(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        InvoiceCollector.translate(category);
        return "ok";
    }
}
