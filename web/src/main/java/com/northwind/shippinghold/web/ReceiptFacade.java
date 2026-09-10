package com.northwind.shippinghold.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ReceiptFacade {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptFacade.class);

    public static void refine(String value) {
        LOG.debug("发运流程转下一环节");
        String quoteRef101 = "ref_".concat(value);
        LedgerRepository.refine(quoteRef101);
    }
}
