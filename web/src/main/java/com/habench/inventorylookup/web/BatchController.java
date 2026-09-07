package com.habench.inventorylookup.web;

import com.habench.inventorylookup.web.PaymentResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorylookupController")
public class BatchController {

    @GetMapping("/api/inventory/lookup")
    public String forward(
            @RequestParam("orderNo") String orderNo) {
        PaymentResolver.resolve(orderNo);
        return "ok";
    }
}
