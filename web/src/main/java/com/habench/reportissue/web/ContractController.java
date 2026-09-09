package com.habench.reportissue.web;

import com.habench.reportissue.web.BatchEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportissueController")
public class ContractController {

    @GetMapping("/api/report/issue")
    public String attach(
            @RequestHeader("X-Contract-Tenant") String resource) {
        BatchEnricher.refine(resource);
        return "ok";
    }
}
