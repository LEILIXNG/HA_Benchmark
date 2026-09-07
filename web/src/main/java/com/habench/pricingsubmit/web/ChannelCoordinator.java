package com.habench.pricingsubmit.web;

import com.habench.pricingsubmit.web.VoucherEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {
    private String pendingVoucher;

    public static void route(String value) {
        ChannelCoordinator self = new ChannelCoordinator();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        this.pendingVoucher = invoiceKey2;
        enrich();
    }

    private void enrich() {
        String batchTag3 = this.pendingVoucher;
        String orderRef4 = "ref:" + batchTag3 + ";";
        Map<String, String> quoteRef5Attrs = new HashMap<String, String>();
        quoteRef5Attrs.put("channel", "web");
        quoteRef5Attrs.put("payload", orderRef4);
        String quoteRef5 = quoteRef5Attrs.get("payload");
        VoucherEvaluator.resolve(quoteRef5);
    }
}
