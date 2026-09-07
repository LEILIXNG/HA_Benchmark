package com.habench.vendormerge.web;

import com.habench.vendormerge.web.OrderBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendormergeController")
public class BatchController {

    @GetMapping("/api/vendor/merge")
    public String enrich(
            @RequestParam("token") String token) {
        OrderBroker.refine(token);
        return "ok";
    }
}
