package com.habench.accounttrace.web;

import com.habench.accounttrace.web.QuoteCoordinator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("accounttraceController")
public class BatchController {

    @GetMapping("/api/account/trace/{reference}")
    public String collect(
            @PathVariable("reference") String reference) {
        QuoteCoordinator.reconcile(reference);
        return "ok";
    }
}
