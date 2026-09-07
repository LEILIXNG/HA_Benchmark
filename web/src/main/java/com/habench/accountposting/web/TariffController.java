package com.habench.accountposting.web;

import com.habench.accountposting.web.TariffEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountpostingController")
public class TariffController {

    @GetMapping("/api/account/posting")
    public String collect(
            @RequestParam("label") String label) {
        TariffEnricher.resolve(label);
        return "ok";
    }
}
