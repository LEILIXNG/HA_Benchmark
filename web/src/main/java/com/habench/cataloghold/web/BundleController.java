package com.habench.cataloghold.web;

import com.habench.cataloghold.web.ContractRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogholdController")
public class BundleController {

    @GetMapping("/api/catalog/hold/{category}")
    public String translate(
            @PathVariable("category") String category) {
        ContractRouter.translate(category);
        return "ok";
    }
}
