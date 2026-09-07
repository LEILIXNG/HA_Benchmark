package com.habench.catalogledger.web;

import com.habench.catalogledger.web.TariffValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogledgerController")
public class TariffController {

    @GetMapping("/api/catalog/ledger/{keyword}")
    public String collect(
            @PathVariable("keyword") String keyword) {
        TariffValidator.prepare(keyword);
        return "ok";
    }
}
