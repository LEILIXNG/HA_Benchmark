package com.habench.orderreview.web;

import com.habench.orderreview.web.QuoteRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("orderreviewController")
public class SessionController {

    @GetMapping("/api/order/review")
    public String collect(
            @RequestParam("keyword") String keyword) {
        QuoteRouter.prepare(keyword);
        return "ok";
    }
}
