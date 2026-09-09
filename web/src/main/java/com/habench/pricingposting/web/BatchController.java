package com.habench.pricingposting.web;

import com.habench.pricingposting.web.VoucherCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingpostingController")
public class BatchController {

    @GetMapping("/api/pricing/posting")
    public String stage(
            @RequestHeader("X-Batch-Channel") String reference) {
        VoucherCoordinator.refine(reference);
        return "ok";
    }
}
