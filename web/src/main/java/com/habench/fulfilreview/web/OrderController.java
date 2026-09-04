package com.habench.fulfilreview.web;

import com.habench.fulfilreview.web.BundleEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreviewController")
public class OrderController {

    @GetMapping("/api/fulfil/review")
    public String forward(
            @RequestParam("label") String label) {
        BundleEnricher.dispatch(label);
        return "ok";
    }
}
