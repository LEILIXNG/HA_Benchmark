package com.habench.fulfilexport.web;

import com.habench.fulfilexport.web.VoucherBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilexportController")
public class QuoteController {

    @GetMapping("/api/fulfil/export")
    public String translate(
            @RequestParam("reference") String reference) {
        VoucherBuilder.submit(reference);
        return "ok";
    }
}
