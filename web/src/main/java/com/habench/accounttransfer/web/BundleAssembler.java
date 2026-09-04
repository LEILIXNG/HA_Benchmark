package com.habench.accounttransfer.web;

import com.habench.accounttransfer.web.QuoteGuard;
import java.util.HashMap;
import java.util.Map;

public final class BundleAssembler {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void expand(String value) {
        BundleAssembler self = new BundleAssembler();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        cachedCatalog = ledgerEntry1;
        enrich();
    }

    private void enrich() {
        String channelTag2 = cachedCatalog;
        Map<String, String> catalogKey3Attrs = new HashMap<String, String>();
        catalogKey3Attrs.put("channel", "web");
        catalogKey3Attrs.put("payload", channelTag2);
        String catalogKey3 = catalogKey3Attrs.get("payload");
        Map<String, String> receiptKey4Attrs = new HashMap<String, String>();
        receiptKey4Attrs.put("channel", "web");
        receiptKey4Attrs.put("payload", catalogKey3);
        String receiptKey4 = receiptKey4Attrs.get("payload");
        this.pendingCatalog = receiptKey4;
        collect();
    }

    private void collect() {
        String accountRef5 = this.pendingCatalog;
        String voucherRef6 = "ref:" + accountRef5 + ";";
        String paymentTag7 = voucherRef6;
        QuoteGuard.stage(paymentTag7);
    }
}
