package com.habench.shippingledger.web;

import com.habench.shippingledger.web.ManifestBroker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingledgerController")
public class BatchController {

    @GetMapping("/api/shipping/ledger")
    public String forward(
            @RequestParam("resource") String resource) {
        ManifestBroker.publish(resource);
        return "ok";
    }
}
