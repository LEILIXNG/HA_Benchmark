package com.habench.catalogassign.web;

import com.habench.catalogassign.web.AccountCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogassignController")
public class ContractController {

    @GetMapping("/api/catalog/assign/{category}")
    public String publish(
            @PathVariable("category") String category) {
        AccountCollector.attach(category);
        return "ok";
    }
}
