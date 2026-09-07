package com.habench.orderlookup.web;

import com.habench.orderlookup.web.ReceiptBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderlookupController")
public class ContractController {

    @GetMapping("/api/order/lookup/{target}")
    public String forward(
            @PathVariable("target") String target) {
        ReceiptBroker.refine(target);
        return "ok";
    }
}
