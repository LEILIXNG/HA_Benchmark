package com.habench.ordersplit.web;

import com.habench.ordersplit.web.ManifestTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordersplitController")
public class ReceiptController {

    @GetMapping("/api/order/split")
    public String expand(
            @RequestParam("reference") String reference) {
        ManifestTranslator.submit(reference);
        return "ok";
    }
}
