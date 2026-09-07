package com.habench.inventoryassign.web;

import com.habench.inventoryassign.web.ContractService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryassignController")
public class ManifestController {

    @GetMapping("/api/inventory/assign")
    public String expand(
            @RequestParam("query") String query) {
        ContractService.resolve(query);
        return "ok";
    }
}
