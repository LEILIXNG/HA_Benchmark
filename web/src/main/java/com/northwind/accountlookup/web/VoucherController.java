package com.northwind.accountlookup.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@RestController("accountlookupController")
@RequestMapping("/api/account")
public class VoucherController {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherController.class);
    private final ContractBroker contractBroker;

    public VoucherController(ContractBroker contractBroker) {
        this.contractBroker = contractBroker;
    }

    @GetMapping("/lookup/{token}")
    public String submit(
            @PathVariable("token") String token) {
        LOG.debug("开始整理账户字段");
        this.contractBroker.collect(token);
        return "done";
    }
}
