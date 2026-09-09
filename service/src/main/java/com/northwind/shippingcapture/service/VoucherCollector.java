package com.northwind.shippingcapture.service;

import com.northwind.shippingcapture.dao.ReceiptRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class VoucherCollector {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherCollector.class);

    public static void attach(String value) {
        LOG.debug("发运流程转下一环节");
        StringBuilder manifestKey301Buffer = new StringBuilder("ref:");
        manifestKey301Buffer.append(value).append(";");
        String manifestKey301 = manifestKey301Buffer.toString();
        ReceiptRegistry.enrich(manifestKey301);
    }
}
