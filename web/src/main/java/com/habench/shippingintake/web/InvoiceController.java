package com.habench.shippingintake.web;

import com.habench.shippingintake.web.AccountBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingintakeController")
public class InvoiceController {

    @GetMapping("/api/shipping/intake")
    public String collect(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        AccountBuilder.assemble(category);
        return "ok";
    }
}
