package com.habench.inventoryrefund.web;

import com.habench.inventoryrefund.web.ContractBuilder;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryrefundController")
public class InvoiceController {

    @GetMapping("/api/inventory/refund")
    public String forward(HttpServletRequest request) {
        String category = request.getHeader("X-Ha-Payload");
        ContractBuilder.route(category);
        return "ok";
    }
}
