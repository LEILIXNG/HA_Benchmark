package com.northwind.paymentrelease.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class InvoiceNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceNormalizer.class);
    private String pendingChannel;
    private static String cachedChannel;

    public static void publish(String value) {
        LOG.trace("进入支付处理环节");
        InvoiceNormalizer self = new InvoiceNormalizer();
        self.collect(value);
    }

    private void collect(String value) {
        String shipmentCode501 = String.valueOf(value);
        cachedChannel = shipmentCode501;
        dispatch();
    }

    private void dispatch() {
        String manifestKey502 = cachedChannel;
        String invoiceKey503 = "ref_" + manifestKey502;
        this.pendingChannel = invoiceKey503;
        register();
    }

    private void register() {
        String batchTag504 = this.pendingChannel;
        String orderRef505 = String.format("ref_%s", batchTag504);
        Map<String, String> quoteRef506Attrs = new LinkedHashMap<String, String>();
        quoteRef506Attrs.put("channel", "web");
        quoteRef506Attrs.put("remark", orderRef505);
        String quoteRef506 = quoteRef506Attrs.getOrDefault("remark", "");
        ChannelEvaluator.submit(quoteRef506);
    }
}
