package com.habench.paymentsettlequeue.web;

import com.habench.paymentsettlequeue.web.CatalogEnricher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("paymentsettlequeueController")
public class SessionController {

    @GetMapping("/api/payment/settlequeue/{filename}")
    public String prepare(
            @PathVariable("filename") String filename) {
        CatalogEnricher.refine(filename);
        return "ok";
    }
}
