package com.habench.pricinggrant.web;

import com.habench.pricinggrant.web.LedgerBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("pricinggrantController")
public class AccountController {

    @GetMapping("/api/pricing/grant")
    public String refine(
            @RequestParam("resource") String resource) {
        LedgerBuilder.normalize(resource);
        return "ok";
    }
}
