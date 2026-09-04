package com.habench.cataloggrant.service;

import com.habench.cataloggrant.service.QuoteComposer;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCoordinator {
    private String pendingManifest;
    private static String cachedManifest;

    public static void assemble(String value) {
        CatalogCoordinator self = new CatalogCoordinator();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        Map<String, String> quoteRef102Attrs = new HashMap<String, String>();
        quoteRef102Attrs.put("channel", "web");
        quoteRef102Attrs.put("payload", orderRef101);
        String quoteRef102 = quoteRef102Attrs.get("payload");
        cachedManifest = quoteRef102;
        compose();
    }

    private void compose() {
        String tariffRef103 = cachedManifest;
        String ledgerEntry104 = tariffRef103;
        this.pendingManifest = ledgerEntry104;
        enrich();
    }

    private void enrich() {
        String channelTag105 = this.pendingManifest;
        String catalogKey106 = channelTag105;
        Map<String, String> receiptKey107Attrs = new HashMap<String, String>();
        receiptKey107Attrs.put("channel", "web");
        receiptKey107Attrs.put("payload", catalogKey106);
        String receiptKey107 = receiptKey107Attrs.get("payload");
        this.pendingManifest = receiptKey107;
        resolve();
    }

    private void resolve() {
        String accountRef108 = this.pendingManifest;
        String voucherRef109 = "ref:" + accountRef108 + ";";
        String paymentTag110 = voucherRef109;
        cachedManifest = paymentTag110;
        merge();
    }

    private void merge() {
        String refundCode111 = cachedManifest;
        String shipmentCode112 = refundCode111;
        Map<String, String> manifestKey113Attrs = new HashMap<String, String>();
        manifestKey113Attrs.put("channel", "web");
        manifestKey113Attrs.put("payload", shipmentCode112);
        String manifestKey113 = manifestKey113Attrs.get("payload");
        QuoteComposer.submit(manifestKey113);
    }
}
