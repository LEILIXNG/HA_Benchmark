package com.habench.paymentsubmit.web;

import com.habench.paymentsubmit.web.ContractRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentsubmitController")
public class SessionController {

    @GetMapping("/api/payment/submit/{query}")
    public String route(
            @PathVariable("query") String query) {
        ContractRouter.enrich(query);
        return "ok";
    }
}
