package com.habench.inventoryexport.web;

import com.habench.inventoryexport.web.ContractAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryexportController")
public class RefundController {

    @GetMapping("/api/inventory/export/{category}")
    public String enrich(
            @PathVariable("category") String category) {
        ContractAssembler.translate(category);
        return "ok";
    }
}
