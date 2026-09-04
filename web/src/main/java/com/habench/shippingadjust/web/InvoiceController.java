package com.habench.shippingadjust.web;

import com.habench.shippingadjust.web.ManifestCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingadjustController")
public class InvoiceController {

    @GetMapping("/api/shipping/adjust")
    public String translate(
            @RequestParam("orderNo") String orderNo) {
        ManifestCollector.refine(orderNo);
        return "ok";
    }
}
