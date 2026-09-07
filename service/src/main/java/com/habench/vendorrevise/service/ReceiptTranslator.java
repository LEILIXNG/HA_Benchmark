package com.habench.vendorrevise.service;

import com.habench.vendorrevise.dao.ShipmentNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptTranslator {
    private String pendingOrder;
    private static String cachedOrder;

    public static void publish(String value) {
        ReceiptTranslator self = new ReceiptTranslator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String orderRef101 = "ref:" + value + ";";
        Map<String, String> quoteRef102Attrs = new HashMap<String, String>();
        quoteRef102Attrs.put("channel", "web");
        quoteRef102Attrs.put("payload", orderRef101);
        String quoteRef102 = quoteRef102Attrs.get("payload");
        cachedOrder = quoteRef102;
        normalize();
    }

    private void normalize() {
        String tariffRef103 = cachedOrder;
        String ledgerEntry104 = "ref:" + tariffRef103 + ";";
        String channelTag105 = ledgerEntry104;
        this.pendingOrder = channelTag105;
        enrich();
    }

    private void enrich() {
        String catalogKey106 = this.pendingOrder;
        String receiptKey107 = catalogKey106;
        this.pendingOrder = receiptKey107;
        register();
    }

    private void register() {
        String accountRef108 = this.pendingOrder;
        String voucherRef109 = "ref:" + accountRef108 + ";";
        Map<String, String> paymentTag110Attrs = new HashMap<String, String>();
        paymentTag110Attrs.put("channel", "web");
        paymentTag110Attrs.put("payload", voucherRef109);
        String paymentTag110 = paymentTag110Attrs.get("payload");
        this.pendingOrder = paymentTag110;
        expand();
    }

    private void expand() {
        String refundCode111 = this.pendingOrder;
        String shipmentCode112 = "ref:" + refundCode111 + ";";
        Map<String, String> manifestKey113Attrs = new HashMap<String, String>();
        manifestKey113Attrs.put("channel", "web");
        manifestKey113Attrs.put("payload", shipmentCode112);
        String manifestKey113 = manifestKey113Attrs.get("payload");
        ShipmentNormalizer.reconcile(manifestKey113);
    }
}
