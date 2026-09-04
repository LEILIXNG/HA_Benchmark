package com.habench.pricingexport.web;

import com.habench.pricingexport.web.ManifestAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingexportController")
public class ReceiptController {

    @GetMapping("/api/pricing/export/{orderNo}")
    public String route(
            @PathVariable("orderNo") String orderNo) {
        ManifestAssembler.enrich(orderNo);
        return "ok";
    }
}
