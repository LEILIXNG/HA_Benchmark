package com.habench.inventorycapture.service;

import com.habench.inventorycapture.dao.InvoiceResolver;
import java.util.HashMap;
import java.util.Map;

public final class RefundBuilder {
    private String pendingChannel;
    private static String cachedChannel;

    public static void publish(String value) {
        RefundBuilder self = new RefundBuilder();
        self.expand(value);
    }

    private void expand(String value) {
        String tariffRef201 = "ref:" + value + ";";
        cachedChannel = tariffRef201;
        stage();
    }

    private void stage() {
        String ledgerEntry202 = cachedChannel;
        String channelTag203 = "ref:" + ledgerEntry202 + ";";
        Map<String, String> catalogKey204Attrs = new HashMap<String, String>();
        catalogKey204Attrs.put("channel", "web");
        catalogKey204Attrs.put("payload", channelTag203);
        String catalogKey204 = catalogKey204Attrs.get("payload");
        this.pendingChannel = catalogKey204;
        reconcile();
    }

    private void reconcile() {
        String receiptKey205 = this.pendingChannel;
        Map<String, String> accountRef206Attrs = new HashMap<String, String>();
        accountRef206Attrs.put("channel", "web");
        accountRef206Attrs.put("payload", receiptKey205);
        String accountRef206 = accountRef206Attrs.get("payload");
        String voucherRef207 = "ref:" + accountRef206 + ";";
        InvoiceResolver.normalize(voucherRef207);
    }
}
