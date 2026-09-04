package com.habench.vendorposting.web;

import com.habench.vendorposting.web.InvoiceEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorpostingController")
public class BundleController {

    @GetMapping("/api/vendor/posting")
    public String attach(
            @RequestParam("userName") String userName) {
        InvoiceEnricher.submit(userName);
        return "ok";
    }
}
