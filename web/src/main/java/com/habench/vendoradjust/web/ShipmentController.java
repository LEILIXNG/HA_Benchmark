package com.habench.vendoradjust.web;

import com.habench.vendoradjust.web.ReceiptAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendoradjustController")
public class ShipmentController {

    @GetMapping("/api/vendor/adjust")
    public String attach(
            @RequestParam("resource") String resource) {
        ReceiptAdapter.enrich(resource);
        return "ok";
    }
}
