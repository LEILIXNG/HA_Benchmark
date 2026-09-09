package com.habench.billingimport.web;

import com.habench.billingimport.web.VoucherAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingimportController")
public class OrderController {

    @GetMapping("/api/billing/import")
    public String merge(
            @RequestParam("filename") String filename) {
        VoucherAssembler.resolve(filename);
        return "ok";
    }
}
