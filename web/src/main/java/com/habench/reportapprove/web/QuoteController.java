package com.habench.reportapprove.web;

import com.habench.reportapprove.web.PaymentRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportapproveController")
public class QuoteController {

    @GetMapping("/api/report/approve")
    public String stage(
            @RequestParam("reference") String reference) {
        PaymentRouter.prepare(reference);
        return "ok";
    }
}
