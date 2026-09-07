package com.habench.reporttrace.web;

import com.habench.reporttrace.web.ChannelTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("reporttraceController")
public class PaymentController {

    @GetMapping("/api/report/trace/{keyword}")
    public String translate(
            @PathVariable("keyword") String keyword) {
        ChannelTranslator.reconcile(keyword);
        return "ok";
    }
}
