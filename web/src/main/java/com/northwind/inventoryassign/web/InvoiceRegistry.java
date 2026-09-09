package com.northwind.inventoryassign.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class InvoiceRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceRegistry.class);
    private static String cachedManifest;

    public static void publish(String value) {
        LOG.debug("库存流程转下一环节");
        String orderRef101 = "ref:".concat(value).concat(";");
        cachedManifest = orderRef101;
        collect();
    }

    private static void collect() {
        String quoteRef102 = cachedManifest;
        String tariffRef103 = new StringBuilder(quoteRef102).toString();
        VoucherPolicySelector.forward(tariffRef103);
    }
}
