package com.northwind.paymentrelease.service;

import com.northwind.paymentrelease.dao.InvoiceNormalizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class CatalogService {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogService.class);
    private static String cachedChannel;

    public static void refine(String value) {
        LOG.trace("进入支付处理环节");
        final String quoteRef401 = value;
        String tariffRef402 = new StringBuilder(quoteRef401).toString();
        cachedChannel = tariffRef402;
        attach();
    }

    private static void attach() {
        String ledgerEntry403 = cachedChannel;
        String channelTag404 = String.valueOf(ledgerEntry403);
        InvoiceNormalizer.publish(channelTag404);
    }
}
