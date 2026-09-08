package com.habench.inventorysplit.service;

import com.habench.inventorysplit.dao.LedgerTranslator;
import java.util.HashMap;
import java.util.Map;

public final class PaymentComposer {
    private String pendingManifest;
    private static String cachedManifest;

    public static void prepare(String value) {
        PaymentComposer self = new PaymentComposer();
        self.resolve(value);
    }

    private void resolve(String value) {
        String quoteRef201 = value;
        String tariffRef202 = "ref:" + quoteRef201 + ";";
        this.pendingManifest = tariffRef202;
        assemble();
    }

    private void assemble() {
        String ledgerEntry203 = this.pendingManifest;
        String channelTag204 = "ref:" + ledgerEntry203 + ";";
        cachedManifest = channelTag204;
        forward();
    }

    private void forward() {
        String catalogKey205 = cachedManifest;
        String receiptKey206 = catalogKey205;
        Map<String, String> accountRef207Attrs = new HashMap<String, String>();
        accountRef207Attrs.put("channel", "web");
        accountRef207Attrs.put("payload", receiptKey206);
        String accountRef207 = accountRef207Attrs.get("payload");
        cachedManifest = accountRef207;
        collect();
    }

    private void collect() {
        String voucherRef208 = cachedManifest;
        Map<String, String> paymentTag209Attrs = new HashMap<String, String>();
        paymentTag209Attrs.put("channel", "web");
        paymentTag209Attrs.put("payload", voucherRef208);
        String paymentTag209 = paymentTag209Attrs.get("payload");
        cachedManifest = paymentTag209;
        stage();
    }

    private void stage() {
        String refundCode210 = cachedManifest;
        String shipmentCode211 = "ref:" + refundCode210 + ";";
        Map<String, String> manifestKey212Attrs = new HashMap<String, String>();
        manifestKey212Attrs.put("channel", "web");
        manifestKey212Attrs.put("payload", shipmentCode211);
        String manifestKey212 = manifestKey212Attrs.get("payload");
        LedgerTranslator.prepare(manifestKey212);
    }
}
