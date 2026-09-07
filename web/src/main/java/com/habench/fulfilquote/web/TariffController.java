package com.habench.fulfilquote.web;

import com.habench.fulfilquote.web.RefundService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilquoteController")
public class TariffController {

    @GetMapping("/api/fulfil/quote/{target}")
    public String attach(
            @PathVariable("target") String target) {
        RefundService.attach(target);
        return "ok";
    }
}
