package com.habench.paymentdispatch.web;

import com.habench.paymentdispatch.web.VoucherTranslator;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentdispatchController")
public class TariffController {

    @GetMapping("/api/payment/dispatch")
    public String refine(
            @CookieValue("tariff_trace") String orderNo) {
        VoucherTranslator.forward(orderNo);
        return "ok";
    }
}
