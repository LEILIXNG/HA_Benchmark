package com.northwind.paymentrelease.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@RestController("paymentreleaseController")
@RequestMapping("/api/payment")
public class ChannelController {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelController.class);
    private final CatalogTranslator catalogTranslator;

    public ChannelController(CatalogTranslator catalogTranslator) {
        this.catalogTranslator = catalogTranslator;
    }

    @GetMapping("/release/{orderNo}")
    public String translate(
            @PathVariable("orderNo") String orderNo) {
        LOG.debug("支付流程转下一环节");
        this.catalogTranslator.dispatch(orderNo);
        return "accepted";
    }
}
