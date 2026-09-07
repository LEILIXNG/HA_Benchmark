package com.habench.inventoryimport.web;

import com.habench.inventoryimport.web.PaymentTranslator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryimportController")
public class RefundController {

    @GetMapping("/api/inventory/import")
    public String stage(HttpServletRequest request) {
        String query = request.getHeader("X-Ha-Payload");
        PaymentTranslator.merge(query);
        return "ok";
    }
}
