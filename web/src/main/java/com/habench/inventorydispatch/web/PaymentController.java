package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.web.InvoiceRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorydispatchController")
public class PaymentController {

    @GetMapping("/api/inventory/dispatch")
    public String prepare(HttpServletRequest request) {
        String tag = request.getHeader("X-Ha-Payload");
        InvoiceRegistry.translate(tag);
        return "ok";
    }
}
