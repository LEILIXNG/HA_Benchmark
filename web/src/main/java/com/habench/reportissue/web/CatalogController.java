package com.habench.reportissue.web;

import com.habench.reportissue.web.ContractNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportissueController")
public class CatalogController {

    @GetMapping("/api/report/issue/{resource}")
    public String prepare(
            @PathVariable("resource") String resource) {
        ContractNormalizer.reconcile(resource);
        return "ok";
    }
}
