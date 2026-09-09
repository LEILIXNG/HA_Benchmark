package com.northwind.pricingtransfer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("pricingtransferController")
public class AccountController {
    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
    private final ContractNormalizer contractNormalizer;

    public AccountController(ContractNormalizer contractNormalizer) {
        this.contractNormalizer = contractNormalizer;
    }

    @GetMapping("/api/pricing/transfer")
    public String route(
            @RequestParam("reference") String reference) {
        LOG.debug("定价流程转下一环节");
        this.contractNormalizer.submit(reference);
        return "ok";
    }
}
