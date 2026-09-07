package com.habench.vendorreview.web;

import com.habench.vendorreview.web.QuoteCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("vendorreviewController")
public class OrderController {

    @GetMapping("/api/vendor/review")
    public String stage(
            @RequestParam("reference") String reference) {
        QuoteCoordinator.translate(reference);
        return "ok";
    }
}
