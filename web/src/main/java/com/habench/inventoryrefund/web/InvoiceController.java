package com.habench.inventoryrefund.web;

import com.habench.inventoryrefund.web.TariffRegistry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryrefundController")
public class InvoiceController {

    @GetMapping("/api/inventory/refund")
    public String collect(HttpServletRequest request) {
        String query = request.getHeader("X-Invoice-Correlation");
        TariffRegistry.reconcile(query);
        return "ok";
    }
}
