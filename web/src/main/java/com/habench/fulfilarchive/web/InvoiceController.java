package com.habench.fulfilarchive.web;

import com.habench.fulfilarchive.web.BundleAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilarchiveController")
public class InvoiceController {

    @GetMapping("/api/fulfil/archive")
    public String submit(
            @RequestParam("q") String q) {
        BundleAdapter.enrich(q);
        return "ok";
    }
}
