package com.habench.catalogbind.web;

import com.habench.catalogbind.web.PaymentAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("catalogbindController")
public class TariffController {

    @GetMapping("/api/catalog/bind/{category}")
    public String compose(
            @PathVariable("category") String category) {
        PaymentAssembler.forward(category);
        return "ok";
    }
}
