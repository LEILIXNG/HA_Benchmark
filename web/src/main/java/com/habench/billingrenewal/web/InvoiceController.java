package com.habench.billingrenewal.web;

import com.habench.billingrenewal.web.BundleAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingrenewalController")
public class InvoiceController {

    @GetMapping("/api/billing/renewal")
    public String submit(
            @RequestParam("q") String q) {
        BundleAdapter.enrich(q);
        return "ok";
    }
}
