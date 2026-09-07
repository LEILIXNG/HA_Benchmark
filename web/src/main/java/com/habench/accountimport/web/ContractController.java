package com.habench.accountimport.web;

import com.habench.accountimport.web.CatalogCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountimportController")
public class ContractController {

    @GetMapping("/api/account/import/{filename}")
    public String collect(
            @PathVariable("filename") String filename) {
        CatalogCollector.assemble(filename);
        return "ok";
    }
}
