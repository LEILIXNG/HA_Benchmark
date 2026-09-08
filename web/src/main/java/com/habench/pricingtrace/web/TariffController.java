package com.habench.pricingtrace.web;

import com.habench.pricingtrace.web.InvoiceBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingtraceController")
public class TariffController {

    @GetMapping("/api/pricing/trace/{query}")
    public String resolve(
            @PathVariable("query") String query) {
        InvoiceBroker.resolve(query);
        return "ok";
    }
}
