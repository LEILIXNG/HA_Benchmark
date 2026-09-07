package com.habench.customersubmit.web;

import com.habench.customersubmit.web.ReceiptEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("customersubmitController")
public class CatalogController {

    @GetMapping("/api/customer/submit/{keyword}")
    public String stage(
            @PathVariable("keyword") String keyword) {
        ReceiptEnricher.merge(keyword);
        return "ok";
    }
}
