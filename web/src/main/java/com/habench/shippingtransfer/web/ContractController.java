package com.habench.shippingtransfer.web;

import com.habench.shippingtransfer.web.SessionEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("shippingtransferController")
public class ContractController {

    @GetMapping("/api/shipping/transfer/{tag}")
    public String merge(
            @PathVariable("tag") String tag) {
        SessionEnricher.compose(tag);
        return "ok";
    }
}
