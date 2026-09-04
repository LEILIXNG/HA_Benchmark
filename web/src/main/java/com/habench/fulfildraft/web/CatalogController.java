package com.habench.fulfildraft.web;

import com.habench.fulfildraft.web.ContractTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfildraftController")
public class CatalogController {

    @GetMapping("/api/fulfil/draft")
    public String publish(
            @RequestParam("label") String label) {
        ContractTranslator.register(label);
        return "ok";
    }
}
