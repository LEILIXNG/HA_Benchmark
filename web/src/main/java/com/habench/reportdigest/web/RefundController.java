package com.habench.reportdigest.web;

import com.habench.reportdigest.web.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportdigestController")
public class RefundController {

    @GetMapping("/api/report/digest")
    public String normalize(
            @RequestParam("tag") String tag) {
        PaymentService.merge(tag);
        return "ok";
    }
}
