package com.habench.pricingcapture.web;

import com.habench.pricingcapture.web.VoucherRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingcaptureController")
public class BatchController {

    @GetMapping("/api/pricing/capture")
    public String prepare(
            @RequestParam("resource") String resource) {
        VoucherRouter.enrich(resource);
        return "ok";
    }
}
