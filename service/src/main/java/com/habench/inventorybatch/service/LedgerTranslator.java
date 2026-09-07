package com.habench.inventorybatch.service;

import com.habench.inventorybatch.dao.PaymentCollector;
import java.util.HashMap;
import java.util.Map;

public final class LedgerTranslator {
    private String pendingInvoice;
    private static String cachedInvoice;

    public static void translate(String value) {
        LedgerTranslator self = new LedgerTranslator();
        self.normalize(value);
    }

    private void normalize(String value) {
        String tariffRef201 = value;
        this.pendingInvoice = tariffRef201;
        compose();
    }

    private void compose() {
        String ledgerEntry202 = this.pendingInvoice;
        Map<String, String> channelTag203Attrs = new HashMap<String, String>();
        channelTag203Attrs.put("channel", "web");
        channelTag203Attrs.put("payload", ledgerEntry202);
        String channelTag203 = channelTag203Attrs.get("payload");
        Map<String, String> catalogKey204Attrs = new HashMap<String, String>();
        catalogKey204Attrs.put("channel", "web");
        catalogKey204Attrs.put("payload", channelTag203);
        String catalogKey204 = catalogKey204Attrs.get("payload");
        cachedInvoice = catalogKey204;
        enrich();
    }

    private void enrich() {
        String receiptKey205 = cachedInvoice;
        Map<String, String> accountRef206Attrs = new HashMap<String, String>();
        accountRef206Attrs.put("channel", "web");
        accountRef206Attrs.put("payload", receiptKey205);
        String accountRef206 = accountRef206Attrs.get("payload");
        Map<String, String> voucherRef207Attrs = new HashMap<String, String>();
        voucherRef207Attrs.put("channel", "web");
        voucherRef207Attrs.put("payload", accountRef206);
        String voucherRef207 = voucherRef207Attrs.get("payload");
        PaymentCollector.assemble(voucherRef207);
    }
}
