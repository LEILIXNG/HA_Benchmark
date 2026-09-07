package com.habench.shippingsplit.web;

import com.habench.shippingsplit.web.BatchComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingsplitController")
public class ContractController {

    @GetMapping("/api/shipping/split")
    public String normalize(
            @RequestParam("orderNo") String orderNo) {
        BatchComposer.register(orderNo);
        return "ok";
    }
}
