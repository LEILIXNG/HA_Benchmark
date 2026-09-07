package com.habench.shippingsubmit.web;

import com.habench.shippingsubmit.web.OrderScreen;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {
    private String pendingSession;
    private static String cachedSession;

    public static void route(String value) {
        VoucherRouter self = new VoucherRouter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        cachedSession = quoteRef1;
        collect();
    }

    private void collect() {
        String tariffRef2 = cachedSession;
        Map<String, String> ledgerEntry3Attrs = new HashMap<String, String>();
        ledgerEntry3Attrs.put("channel", "web");
        ledgerEntry3Attrs.put("payload", tariffRef2);
        String ledgerEntry3 = ledgerEntry3Attrs.get("payload");
        Map<String, String> channelTag4Attrs = new HashMap<String, String>();
        channelTag4Attrs.put("channel", "web");
        channelTag4Attrs.put("payload", ledgerEntry3);
        String channelTag4 = channelTag4Attrs.get("payload");
        cachedSession = channelTag4;
        merge();
    }

    private void merge() {
        String catalogKey5 = cachedSession;
        String receiptKey6 = catalogKey5;
        String accountRef7 = receiptKey6;
        this.pendingSession = accountRef7;
        register();
    }

    private void register() {
        String voucherRef8 = this.pendingSession;
        Map<String, String> paymentTag9Attrs = new HashMap<String, String>();
        paymentTag9Attrs.put("channel", "web");
        paymentTag9Attrs.put("payload", voucherRef8);
        String paymentTag9 = paymentTag9Attrs.get("payload");
        OrderScreen.resolve(paymentTag9);
    }
}
