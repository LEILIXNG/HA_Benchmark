package com.habench.paymentledger.web;

import com.habench.paymentledger.web.SessionRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentledgerController")
public class OrderController {

    @GetMapping("/api/payment/ledger/{orderNo}")
    public String reconcile(
            @PathVariable("orderNo") String orderNo) {
        SessionRouter.resolve(orderNo);
        return "ok";
    }
}
