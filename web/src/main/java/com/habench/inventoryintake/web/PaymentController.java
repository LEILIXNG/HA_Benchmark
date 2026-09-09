package com.habench.inventoryintake.web;

import com.habench.inventoryintake.web.ContractTranslator;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryintakeController")
public class PaymentController {

    @GetMapping("/api/inventory/intake")
    public String reconcile(
            @CookieValue("payment_tag") String label) {
        ContractTranslator.register(label);
        return "ok";
    }
}
