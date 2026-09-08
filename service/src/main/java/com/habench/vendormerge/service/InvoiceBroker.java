package com.habench.vendormerge.service;

import com.habench.vendormerge.service.CatalogPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBroker {
    private static String cachedCatalog;

    public static void submit(String value) {
        String batchTag201 = value;
        String orderRef202 = batchTag201;
        cachedCatalog = orderRef202;
        compose();
    }

    private static void compose() {
        String quoteRef203 = cachedCatalog;
        Map<String, String> tariffRef204Attrs = new HashMap<String, String>();
        tariffRef204Attrs.put("channel", "web");
        tariffRef204Attrs.put("payload", quoteRef203);
        String tariffRef204 = tariffRef204Attrs.get("payload");
        cachedCatalog = tariffRef204;
        expand();
    }

    private static void expand() {
        String ledgerEntry205 = cachedCatalog;
        String channelTag206 = ledgerEntry205;
        Map<String, String> catalogKey207Attrs = new HashMap<String, String>();
        catalogKey207Attrs.put("channel", "web");
        catalogKey207Attrs.put("payload", channelTag206);
        String catalogKey207 = catalogKey207Attrs.get("payload");
        cachedCatalog = catalogKey207;
        reconcile();
    }

    private static void reconcile() {
        String receiptKey208 = cachedCatalog;
        String accountRef209 = "ref:" + receiptKey208 + ";";
        Map<String, String> voucherRef210Attrs = new HashMap<String, String>();
        voucherRef210Attrs.put("channel", "web");
        voucherRef210Attrs.put("payload", accountRef209);
        String voucherRef210 = voucherRef210Attrs.get("payload");
        CatalogPolicySelector.collect(voucherRef210);
    }
}
