package com.habench.pricingtrace.web;

import com.habench.pricingtrace.web.BatchFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingtraceController")
public class ShipmentController {

    @GetMapping("/api/pricing/trace/{target}")
    public String expand(
            @PathVariable("target") String target) {
        BatchFacade.reconcile(target);
        return "ok";
    }
}
