package com.habench.fulfilsplit.web;

import com.habench.fulfilsplit.web.OrderBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilsplitController")
public class BatchController {

    @GetMapping("/api/fulfil/split")
    public String enrich(
            @RequestParam("token") String token) {
        OrderBroker.refine(token);
        return "ok";
    }
}
