package com.habench.catalogmanifest.service;

import com.habench.catalogmanifest.service.ManifestStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleTranslator {
    private String pendingChannel;
    private static String cachedChannel;

    public static void route(String value) {
        BundleTranslator self = new BundleTranslator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        cachedChannel = ledgerEntry101;
        refine();
    }

    private void refine() {
        String channelTag102 = cachedChannel;
        String catalogKey103 = channelTag102;
        String receiptKey104 = catalogKey103;
        cachedChannel = receiptKey104;
        expand();
    }

    private void expand() {
        String accountRef105 = cachedChannel;
        Map<String, String> voucherRef106Attrs = new HashMap<String, String>();
        voucherRef106Attrs.put("channel", "web");
        voucherRef106Attrs.put("payload", accountRef105);
        String voucherRef106 = voucherRef106Attrs.get("payload");
        this.pendingChannel = voucherRef106;
        enrich();
    }

    private void enrich() {
        String paymentTag107 = this.pendingChannel;
        String refundCode108 = paymentTag107;
        Map<String, String> shipmentCode109Attrs = new HashMap<String, String>();
        shipmentCode109Attrs.put("channel", "web");
        shipmentCode109Attrs.put("payload", refundCode108);
        String shipmentCode109 = shipmentCode109Attrs.get("payload");
        this.pendingChannel = shipmentCode109;
        translate();
    }

    private void translate() {
        String manifestKey110 = this.pendingChannel;
        String invoiceKey111 = "ref:" + manifestKey110 + ";";
        ManifestStrategySelector.merge(invoiceKey111);
    }
}
