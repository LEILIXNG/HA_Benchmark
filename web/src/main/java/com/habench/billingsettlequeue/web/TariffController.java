package com.habench.billingsettlequeue.web;

import com.habench.billingsettlequeue.web.RefundRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingsettlequeueController")
public class TariffController {

    @GetMapping("/api/billing/settlequeue/{orderNo}")
    public String translate(
            @PathVariable("orderNo") String orderNo) {
        RefundRegistry.translate(orderNo);
        return "ok";
    }
}
