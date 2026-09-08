package com.habench.paymentverify.web;

import com.habench.paymentverify.web.OrderFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentverifyController")
public class InvoiceController {

    @GetMapping("/api/payment/verify/{keyword}")
    public String attach(
            @PathVariable("keyword") String keyword) {
        OrderFacade.assemble(keyword);
        return "ok";
    }
}
