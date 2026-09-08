package com.habench.pricingrenewal.web;

import com.habench.pricingrenewal.web.ReceiptResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricingrenewalController")
public class LedgerController {

    @GetMapping("/api/pricing/renewal")
    public String submit(
            @RequestParam("filename") String filename) {
        ReceiptResolver.expand(filename);
        return "ok";
    }
}
