package com.habench.inventoryrevise.web;

import com.habench.inventoryrevise.web.CatalogBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryreviseController")
public class PaymentController {

    @GetMapping("/api/inventory/revise")
    public String dispatch(
            @RequestHeader("X-Payment-Origin") String label) {
        CatalogBuilder.translate(label);
        return "ok";
    }
}
