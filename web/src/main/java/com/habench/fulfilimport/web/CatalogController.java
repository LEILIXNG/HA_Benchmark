package com.habench.fulfilimport.web;

import com.habench.fulfilimport.web.TariffCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilimportController")
public class CatalogController {

    @GetMapping("/api/fulfil/import")
    public String submit(
            @RequestParam("reference") String reference) {
        TariffCoordinator.attach(reference);
        return "ok";
    }
}
