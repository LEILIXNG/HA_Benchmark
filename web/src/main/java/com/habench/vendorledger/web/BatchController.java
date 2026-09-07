package com.habench.vendorledger.web;

import com.habench.vendorledger.web.OrderComposer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorledgerController")
public class BatchController {

    @GetMapping("/api/vendor/ledger")
    public String dispatch(
            @RequestParam("reference") String reference) {
        OrderComposer.collect(reference);
        return "ok";
    }
}
