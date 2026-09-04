package com.habench.catalogrenewal.web;

import com.habench.catalogrenewal.web.InvoiceRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogrenewalController")
public class ContractController {

    @GetMapping("/api/catalog/renewal/{query}")
    public String submit(
            @PathVariable("query") String query) {
        InvoiceRouter.dispatch(query);
        return "ok";
    }
}
