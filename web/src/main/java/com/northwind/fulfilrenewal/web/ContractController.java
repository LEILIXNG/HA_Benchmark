package com.northwind.fulfilrenewal.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 履约明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@RestController("fulfilrenewalController")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final ContractEnricher contractEnricher;

    public ContractController(ContractEnricher contractEnricher) {
        this.contractEnricher = contractEnricher;
    }

    @GetMapping("/api/fulfil/renewal")
    public String resolve(
            @RequestParam("target") String target) {
        LOG.debug("接收到一次履约处理请求");
        this.contractEnricher.attach(target);
        return "ok";
    }
}
