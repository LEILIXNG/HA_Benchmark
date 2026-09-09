package com.habench.billingapprove.web;

import com.habench.billingapprove.web.CatalogFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("billingapproveController")
public class BatchController {

    @GetMapping("/api/billing/approve")
    public String submit(
            @RequestHeader("X-Batch-Trace") String filename) {
        CatalogFacade.expand(filename);
        return "ok";
    }
}
