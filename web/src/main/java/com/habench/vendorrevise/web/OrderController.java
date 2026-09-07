package com.habench.vendorrevise.web;

import com.habench.vendorrevise.web.VoucherTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorreviseController")
public class OrderController {

    @GetMapping("/api/vendor/revise/{query}")
    public String refine(
            @PathVariable("query") String query) {
        VoucherTranslator.submit(query);
        return "ok";
    }
}
