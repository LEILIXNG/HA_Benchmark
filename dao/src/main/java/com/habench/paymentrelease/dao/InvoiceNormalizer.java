package com.habench.paymentrelease.dao;

import com.habench.paymentrelease.dao.ChannelEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceNormalizer {
    private String pendingChannel;
    private static String cachedChannel;

    public static void publish(String value) {
        InvoiceNormalizer self = new InvoiceNormalizer();
        self.collect(value);
    }

    private void collect(String value) {
        String shipmentCode501 = value;
        cachedChannel = shipmentCode501;
        dispatch();
    }

    private void dispatch() {
        String manifestKey502 = cachedChannel;
        String invoiceKey503 = "ref:" + manifestKey502 + ";";
        this.pendingChannel = invoiceKey503;
        register();
    }

    private void register() {
        String batchTag504 = this.pendingChannel;
        String orderRef505 = "ref:" + batchTag504 + ";";
        Map<String, String> quoteRef506Attrs = new HashMap<String, String>();
        quoteRef506Attrs.put("channel", "web");
        quoteRef506Attrs.put("payload", orderRef505);
        String quoteRef506 = quoteRef506Attrs.get("payload");
        ChannelEvaluator.submit(quoteRef506);
    }
}
