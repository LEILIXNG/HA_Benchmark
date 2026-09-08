package com.habench.inventoryposting.web;

import com.habench.inventoryposting.web.CatalogCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventorypostingController")
public class ContractController {

    @GetMapping("/api/inventory/posting/{target}")
    public String forward(
            @PathVariable("target") String target) {
        CatalogCollector.translate(target);
        return "ok";
    }
}
