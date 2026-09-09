package com.habench.reportrefund.web;

import com.habench.reportrefund.web.InvoiceRouter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("reportrefundController")
public class TariffController {

    @GetMapping("/api/report/refund")
    public String refine(
            @RequestHeader("X-Tariff-Reference") String reference) {
        InvoiceRouter.enrich(reference);
        return "ok";
    }
}
