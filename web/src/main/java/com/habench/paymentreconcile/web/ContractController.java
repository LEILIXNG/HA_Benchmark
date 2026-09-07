package com.habench.paymentreconcile.web;

import com.habench.paymentreconcile.web.CatalogTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentreconcileController")
public class ContractController {

    @GetMapping("/api/payment/reconcile/{userName}")
    public String prepare(
            @PathVariable("userName") String userName) {
        CatalogTranslator.translate(userName);
        return "ok";
    }
}
