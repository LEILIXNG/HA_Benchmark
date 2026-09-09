package com.northwind.reportapprove.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("reportapproveController")
@RequestMapping("/api/report")
public class QuoteController {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteController.class);
    private final VoucherAssembler voucherAssembler;

    public QuoteController(VoucherAssembler voucherAssembler) {
        this.voucherAssembler = voucherAssembler;
    }

    @GetMapping("/approve")
    public String stage(
            @RequestParam("reference") String reference) {
        LOG.debug("报表流程转下一环节");
        this.voucherAssembler.prepare(reference);
        return "accepted";
    }
}
