package com.habench.vendorreopen.web;

import com.habench.vendorreopen.web.InvoiceBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorreopenController")
public class AccountController {

    @GetMapping("/api/vendor/reopen/{tag}")
    public String resolve(
            @PathVariable("tag") String tag) {
        InvoiceBuilder.resolve(tag);
        return "ok";
    }
}
