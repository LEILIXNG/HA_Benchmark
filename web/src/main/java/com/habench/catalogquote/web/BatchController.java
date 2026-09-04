package com.habench.catalogquote.web;

import com.habench.catalogquote.web.TariffAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogquoteController")
public class BatchController {

    @GetMapping("/api/catalog/quote/{label}")
    public String route(
            @PathVariable("label") String label) {
        TariffAssembler.route(label);
        return "ok";
    }
}
