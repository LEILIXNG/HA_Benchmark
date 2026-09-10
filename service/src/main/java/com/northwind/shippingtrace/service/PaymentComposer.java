package com.northwind.shippingtrace.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class PaymentComposer {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentComposer.class);

    public static void forward(String value) {
        LOG.trace("进入发运处理环节");
        StringBuilder manifestKey201Buffer = new StringBuilder("ref_");
        manifestKey201Buffer.append(value);
        String manifestKey201 = manifestKey201Buffer.toString();
        final String invoiceKey202 = manifestKey201;
        BatchLoader.resolve(invoiceKey202);
    }
}
