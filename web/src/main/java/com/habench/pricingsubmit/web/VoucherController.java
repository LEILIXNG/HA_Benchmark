package com.habench.pricingsubmit.web;

import com.habench.pricingsubmit.web.ReceiptCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingsubmitController")
public class VoucherController {

    @GetMapping("/api/pricing/submit/{userName}")
    public String merge(
            @PathVariable("userName") String userName) {
        ReceiptCollector.route(userName);
        return "ok";
    }
}
