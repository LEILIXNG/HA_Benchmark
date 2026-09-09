package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.web.InvoiceValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorydispatchController")
public class ReceiptController {

    @GetMapping("/api/inventory/dispatch")
    public String normalize(
            @RequestHeader("X-Receipt-Context") String target) {
        InvoiceValidator.register(target);
        return "ok";
    }
}
