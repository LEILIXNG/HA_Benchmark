package com.habench.inventoryassign.web;

import com.habench.inventoryassign.web.RefundTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("inventoryassignController")
public class ManifestController {

    @GetMapping("/api/inventory/assign/{target}")
    public String resolve(
            @PathVariable("target") String target) {
        RefundTranslator.refine(target);
        return "ok";
    }
}
