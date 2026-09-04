package com.habench.pricingmerge.service;

import com.habench.pricingmerge.dao.InvoiceTranslator;
import java.util.HashMap;
import java.util.Map;

public final class TariffCollector {
    private String pendingManifest;
    private static String cachedManifest;

    public static void prepare(String value) {
        TariffCollector self = new TariffCollector();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        this.pendingManifest = quoteRef101;
        route();
    }

    private void route() {
        String tariffRef102 = this.pendingManifest;
        Map<String, String> ledgerEntry103Attrs = new HashMap<String, String>();
        ledgerEntry103Attrs.put("channel", "web");
        ledgerEntry103Attrs.put("payload", tariffRef102);
        String ledgerEntry103 = ledgerEntry103Attrs.get("payload");
        cachedManifest = ledgerEntry103;
        compose();
    }

    private void compose() {
        String channelTag104 = cachedManifest;
        String catalogKey105 = channelTag104;
        this.pendingManifest = catalogKey105;
        dispatch();
    }

    private void dispatch() {
        String receiptKey106 = this.pendingManifest;
        Map<String, String> accountRef107Attrs = new HashMap<String, String>();
        accountRef107Attrs.put("channel", "web");
        accountRef107Attrs.put("payload", receiptKey106);
        String accountRef107 = accountRef107Attrs.get("payload");
        InvoiceTranslator.stage(accountRef107);
    }
}
