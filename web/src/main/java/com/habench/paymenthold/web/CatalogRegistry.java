package com.habench.paymenthold.web;

import com.habench.paymenthold.service.SessionComposer;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRegistry {
    private String pendingBatch;
    private static String cachedBatch;

    public static void stage(String value) {
        CatalogRegistry self = new CatalogRegistry();
        self.prepare(value);
    }

    private void prepare(String value) {
        String orderRef101 = "ref:" + value + ";";
        cachedBatch = orderRef101;
        compose();
    }

    private void compose() {
        String quoteRef102 = cachedBatch;
        Map<String, String> tariffRef103Attrs = new HashMap<String, String>();
        tariffRef103Attrs.put("channel", "web");
        tariffRef103Attrs.put("payload", quoteRef102);
        String tariffRef103 = tariffRef103Attrs.get("payload");
        String ledgerEntry104 = tariffRef103;
        this.pendingBatch = ledgerEntry104;
        route();
    }

    private void route() {
        String channelTag105 = this.pendingBatch;
        String catalogKey106 = "ref:" + channelTag105 + ";";
        String receiptKey107 = "ref:" + catalogKey106 + ";";
        cachedBatch = receiptKey107;
        submit();
    }

    private void submit() {
        String accountRef108 = cachedBatch;
        Map<String, String> voucherRef109Attrs = new HashMap<String, String>();
        voucherRef109Attrs.put("channel", "web");
        voucherRef109Attrs.put("payload", accountRef108);
        String voucherRef109 = voucherRef109Attrs.get("payload");
        String paymentTag110 = voucherRef109;
        SessionComposer.stage(paymentTag110);
    }
}
