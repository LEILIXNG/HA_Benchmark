package com.habench.catalogadjust.web;

import com.habench.catalogadjust.web.InvoiceBuilder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogadjustController")
public class InvoiceController {

    @GetMapping("/api/catalog/adjust")
    public String resolve(
            @CookieValue("invoice_tag") String target) {
        InvoiceBuilder.attach(target);
        return "ok";
    }
}
