package com.habench.fulfilposting.web;

import com.habench.fulfilposting.web.RefundTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilpostingController")
public class ChannelController {

    @GetMapping("/api/fulfil/posting")
    public String route(
            @RequestParam("query") String query) {
        RefundTranslator.reconcile(query);
        return "ok";
    }
}
