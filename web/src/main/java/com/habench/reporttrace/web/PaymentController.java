package com.habench.reporttrace.web;

import com.habench.reporttrace.web.ContractEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("reporttraceController")
public class PaymentController {

    @GetMapping("/api/report/trace")
    public String reconcile(
            @RequestParam("category") String category) {
        ContractEnricher.publish(category);
        return "ok";
    }
}
