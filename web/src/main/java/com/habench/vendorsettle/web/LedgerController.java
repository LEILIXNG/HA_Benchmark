package com.habench.vendorsettle.web;

import com.habench.vendorsettle.web.TariffNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorsettleController")
public class LedgerController {

    @GetMapping("/api/vendor/settle/{target}")
    public String enrich(
            @PathVariable("target") String target) {
        TariffNormalizer.collect(target);
        return "ok";
    }
}
