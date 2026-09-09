package com.northwind.vendoradjust.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("vendoradjustController")
public class InvoiceController {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);
    private final RefundEnricher refundEnricher;

    public InvoiceController(RefundEnricher refundEnricher) {
        this.refundEnricher = refundEnricher;
    }

    @GetMapping("/api/vendor/adjust")
    public String register(
            @RequestHeader("X-Invoice-Tenant") String query) {
        LOG.trace("进入供应商处理环节");
        this.refundEnricher.expand(query);
        return "ok";
    }
}
