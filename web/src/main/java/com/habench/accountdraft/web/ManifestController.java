package com.habench.accountdraft.web;

import com.habench.accountdraft.web.TariffEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accountdraftController")
public class ManifestController {

    @GetMapping("/api/account/draft/{filename}")
    public String dispatch(
            @PathVariable("filename") String filename) {
        TariffEnricher.prepare(filename);
        return "ok";
    }
}
