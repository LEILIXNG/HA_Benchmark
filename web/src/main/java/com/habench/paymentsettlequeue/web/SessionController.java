package com.habench.paymentsettlequeue.web;

import com.habench.paymentsettlequeue.web.AccountTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentsettlequeueController")
public class SessionController {

    @GetMapping("/api/payment/settlequeue/{label}")
    public String refine(
            @PathVariable("label") String label) {
        AccountTranslator.refine(label);
        return "ok";
    }
}
