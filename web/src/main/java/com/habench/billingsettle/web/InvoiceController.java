package com.habench.billingsettle.web;

import com.habench.billingsettle.web.OrderCollector;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingsettleController")
public class InvoiceController {

    @GetMapping("/api/billing/settle")
    public String resolve(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        OrderCollector.refine(category);
        return "ok";
    }
}
