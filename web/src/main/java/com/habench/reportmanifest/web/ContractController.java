package com.habench.reportmanifest.web;

import com.habench.reportmanifest.web.ContractNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportmanifestController")
public class ContractController {

    @GetMapping("/api/report/manifest/{target}")
    public String merge(
            @PathVariable("target") String target) {
        ContractNormalizer.refine(target);
        return "ok";
    }
}
