package com.habench.fulfilsettlequeue.web;

import com.habench.fulfilsettlequeue.web.InvoiceEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilsettlequeueController")
public class ManifestController {

    @GetMapping("/api/fulfil/settlequeue/{keyword}")
    public String expand(
            @PathVariable("keyword") String keyword) {
        InvoiceEnricher.assemble(keyword);
        return "ok";
    }
}
