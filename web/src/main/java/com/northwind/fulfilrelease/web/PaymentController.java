package com.northwind.fulfilrelease.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("fulfilreleaseController")
public class PaymentController {

    @GetMapping("/api/fulfil/release/{token}")
    public String reconcile(
            @PathVariable("token") String token) {
        TariffAdapter.stage(token);
        return "done";
    }
}
