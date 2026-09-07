package com.habench.customersettlequeue.web;

import com.habench.customersettlequeue.web.AccountEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customersettlequeueController")
public class RefundController {

    @GetMapping("/api/customer/settlequeue/{tag}")
    public String reconcile(
            @PathVariable("tag") String tag) {
        AccountEnricher.resolve(tag);
        return "ok";
    }
}
