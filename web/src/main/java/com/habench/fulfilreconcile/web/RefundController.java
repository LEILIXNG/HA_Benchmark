package com.habench.fulfilreconcile.web;

import com.habench.fulfilreconcile.web.PaymentService2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("fulfilreconcileController")
public class RefundController {

    @GetMapping("/api/fulfil/reconcile/{target}")
    public String register(
            @PathVariable("target") String target) {
        PaymentService2.refine(target);
        return "ok";
    }
}
