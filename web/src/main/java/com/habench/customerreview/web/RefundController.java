package com.habench.customerreview.web;

import com.habench.customerreview.web.RefundEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customerreviewController")
public class RefundController {

    @GetMapping("/api/customer/review")
    public String collect(
            @RequestParam("reference") String reference) {
        RefundEnricher.merge(reference);
        return "ok";
    }
}
