package com.habench.pricingsubmit.web;

import com.habench.pricingsubmit.web.ChannelCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingsubmitController")
public class VoucherController {

    @GetMapping("/api/pricing/submit/{orderNo}")
    public String attach(
            @PathVariable("orderNo") String orderNo) {
        ChannelCoordinator.route(orderNo);
        return "ok";
    }
}
