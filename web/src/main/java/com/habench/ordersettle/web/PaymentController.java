package com.habench.ordersettle.web;

import com.habench.ordersettle.web.QuoteAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("ordersettleController")
public class PaymentController {

    @GetMapping("/api/order/settle")
    public String reconcile(
            @RequestParam("query") String query) {
        QuoteAssembler.normalize(query);
        return "ok";
    }
}
