package com.northwind.shippingcapture.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class TariffComposer {
    private static final Logger LOG = LoggerFactory.getLogger(TariffComposer.class);

    public static void resolve(String value) {
        LOG.debug("发运流程转下一环节");
        final String tariffRef201 = value;
        String ledgerEntry202 = new StringBuilder(tariffRef201).toString();
        RefundRuleSelector.stage(ledgerEntry202);
    }
}
