package com.habench.catalogrenewal.web;

import com.habench.catalogrenewal.web.LedgerCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogrenewalController")
public class ContractController {

    @GetMapping("/api/catalog/renewal/{token}")
    public String submit(
            @PathVariable("token") String token) {
        LedgerCollector.assemble(token);
        return "ok";
    }
}
