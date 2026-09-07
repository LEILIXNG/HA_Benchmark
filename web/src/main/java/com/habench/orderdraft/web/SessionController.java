package com.habench.orderdraft.web;

import com.habench.orderdraft.web.BatchEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderdraftController")
public class SessionController {

    @GetMapping("/api/order/draft")
    public String merge(
            @RequestParam("reference") String reference) {
        BatchEnricher.refine(reference);
        return "ok";
    }
}
