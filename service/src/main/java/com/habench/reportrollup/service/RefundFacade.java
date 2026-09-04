package com.habench.reportrollup.service;

import com.habench.reportrollup.service.BundleLoader;
import java.util.HashMap;
import java.util.Map;

public final class RefundFacade {
    private String pendingBundle;
    private static String cachedBundle;

    public static void merge(String value) {
        RefundFacade self = new RefundFacade();
        self.collect(value);
    }

    private void collect(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = orderRef101;
        this.pendingBundle = quoteRef102;
        resolve();
    }

    private void resolve() {
        String tariffRef103 = this.pendingBundle;
        String ledgerEntry104 = tariffRef103;
        String channelTag105 = ledgerEntry104;
        this.pendingBundle = channelTag105;
        expand();
    }

    private void expand() {
        String catalogKey106 = this.pendingBundle;
        Map<String, String> receiptKey107Attrs = new HashMap<String, String>();
        receiptKey107Attrs.put("channel", "web");
        receiptKey107Attrs.put("payload", catalogKey106);
        String receiptKey107 = receiptKey107Attrs.get("payload");
        Map<String, String> accountRef108Attrs = new HashMap<String, String>();
        accountRef108Attrs.put("channel", "web");
        accountRef108Attrs.put("payload", receiptKey107);
        String accountRef108 = accountRef108Attrs.get("payload");
        cachedBundle = accountRef108;
        normalize();
    }

    private void normalize() {
        String voucherRef109 = cachedBundle;
        String paymentTag110 = voucherRef109;
        Map<String, String> refundCode111Attrs = new HashMap<String, String>();
        refundCode111Attrs.put("channel", "web");
        refundCode111Attrs.put("payload", paymentTag110);
        String refundCode111 = refundCode111Attrs.get("payload");
        BundleLoader.prepare(refundCode111);
    }
}
