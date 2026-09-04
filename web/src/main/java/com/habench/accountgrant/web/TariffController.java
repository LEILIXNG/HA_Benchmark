package com.habench.accountgrant.web;

import com.habench.accountgrant.web.OrderAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountgrantController")
public class TariffController {

    @GetMapping("/api/account/grant")
    public String resolve(
            @RequestParam("target") String target) {
        OrderAssembler.enrich(target);
        return "ok";
    }
}
