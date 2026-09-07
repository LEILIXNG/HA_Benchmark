package com.habench.paymentdigest.web;

import com.habench.paymentdigest.web.InvoiceResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentdigestController")
public class ContractController {

    @GetMapping("/api/payment/digest")
    public String enrich(
            @RequestParam("orderNo") String orderNo) {
        InvoiceResolver.route(orderNo);
        return "ok";
    }
}
