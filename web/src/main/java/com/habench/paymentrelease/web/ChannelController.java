package com.habench.paymentrelease.web;

import com.habench.paymentrelease.web.CatalogTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentreleaseController")
public class ChannelController {

    @GetMapping("/api/payment/release/{orderNo}")
    public String translate(
            @PathVariable("orderNo") String orderNo) {
        CatalogTranslator.dispatch(orderNo);
        return "ok";
    }
}
