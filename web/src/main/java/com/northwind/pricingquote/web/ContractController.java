package com.northwind.pricingquote.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定价处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@RestController("pricingquoteController")
public class ContractController {
    private static final Logger LOG = LoggerFactory.getLogger(ContractController.class);
    private final TariffTranslator tariffTranslator;

    public ContractController(TariffTranslator tariffTranslator) {
        this.tariffTranslator = tariffTranslator;
    }

    @GetMapping("/api/pricing/quote")
    public String expand(
            @CookieValue("contract_ref") String resource) {
        LOG.debug("定价流程转下一环节");
        this.tariffTranslator.resolve(resource);
        return "ok";
    }
}
