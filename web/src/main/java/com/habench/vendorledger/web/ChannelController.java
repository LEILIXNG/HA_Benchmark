package com.habench.vendorledger.web;

import com.habench.vendorledger.web.ReceiptNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorledgerController")
public class ChannelController {

    @GetMapping("/api/vendor/ledger/{query}")
    public String register(
            @PathVariable("query") String query) {
        ReceiptNormalizer.resolve(query);
        return "ok";
    }
}
