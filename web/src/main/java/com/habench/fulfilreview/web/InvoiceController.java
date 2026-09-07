package com.habench.fulfilreview.web;

import com.habench.fulfilreview.web.ManifestNormalizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreviewController")
public class InvoiceController {

    @GetMapping("/api/fulfil/review")
    public String publish(
            @RequestParam("orderNo") String orderNo) {
        ManifestNormalizer.submit(orderNo);
        return "ok";
    }
}
