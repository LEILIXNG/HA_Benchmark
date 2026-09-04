package com.habench.pricingrenewal.service;

import com.habench.pricingrenewal.service.SessionLoader;
import java.util.HashMap;
import java.util.Map;

public final class AccountEnricher {
    private String pendingSession;
    private static String cachedSession;

    public static void prepare(String value) {
        AccountEnricher self = new AccountEnricher();
        self.expand(value);
    }

    private void expand(String value) {
        String manifestKey301 = "ref:" + value + ";";
        String invoiceKey302 = "ref:" + manifestKey301 + ";";
        cachedSession = invoiceKey302;
        dispatch();
    }

    private void dispatch() {
        String batchTag303 = cachedSession;
        String orderRef304 = "ref:" + batchTag303 + ";";
        String quoteRef305 = "ref:" + orderRef304 + ";";
        this.pendingSession = quoteRef305;
        normalize();
    }

    private void normalize() {
        String tariffRef306 = this.pendingSession;
        Map<String, String> ledgerEntry307Attrs = new HashMap<String, String>();
        ledgerEntry307Attrs.put("channel", "web");
        ledgerEntry307Attrs.put("payload", tariffRef306);
        String ledgerEntry307 = ledgerEntry307Attrs.get("payload");
        String channelTag308 = "ref:" + ledgerEntry307 + ";";
        cachedSession = channelTag308;
        reconcile();
    }

    private void reconcile() {
        String catalogKey309 = cachedSession;
        Map<String, String> receiptKey310Attrs = new HashMap<String, String>();
        receiptKey310Attrs.put("channel", "web");
        receiptKey310Attrs.put("payload", catalogKey309);
        String receiptKey310 = receiptKey310Attrs.get("payload");
        SessionLoader.enrich(receiptKey310);
    }
}
