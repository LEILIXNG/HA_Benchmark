package com.habench.customerquote.service;

import com.habench.customerquote.service.AccountLoader;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCollector {
    private String pendingAccount;
    private static String cachedAccount;

    public static void normalize(String value) {
        ReceiptCollector self = new ReceiptCollector();
        self.prepare(value);
    }

    private void prepare(String value) {
        String quoteRef201 = "ref:" + value + ";";
        this.pendingAccount = quoteRef201;
        enrich();
    }

    private void enrich() {
        String tariffRef202 = this.pendingAccount;
        Map<String, String> ledgerEntry203Attrs = new HashMap<String, String>();
        ledgerEntry203Attrs.put("channel", "web");
        ledgerEntry203Attrs.put("payload", tariffRef202);
        String ledgerEntry203 = ledgerEntry203Attrs.get("payload");
        cachedAccount = ledgerEntry203;
        compose();
    }

    private void compose() {
        String channelTag204 = cachedAccount;
        Map<String, String> catalogKey205Attrs = new HashMap<String, String>();
        catalogKey205Attrs.put("channel", "web");
        catalogKey205Attrs.put("payload", channelTag204);
        String catalogKey205 = catalogKey205Attrs.get("payload");
        AccountLoader.route(catalogKey205);
    }
}
