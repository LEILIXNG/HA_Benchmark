package com.habench.pricingrollup.web;

import com.habench.pricingrollup.web.VoucherFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingrollupController")
public class ChannelController {

    @GetMapping("/api/pricing/rollup/{orderNo}")
    public String enrich(
            @PathVariable("orderNo") String orderNo) {
        VoucherFacade.enrich(orderNo);
        return "ok";
    }
}
