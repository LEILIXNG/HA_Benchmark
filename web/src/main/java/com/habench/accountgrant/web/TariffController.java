package com.habench.accountgrant.web;

import com.habench.accountgrant.web.ManifestCollector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountgrantController")
public class TariffController {

    @GetMapping("/api/account/grant/{userName}")
    public String assemble(
            @PathVariable("userName") String userName) {
        ManifestCollector.refine(userName);
        return "ok";
    }
}
