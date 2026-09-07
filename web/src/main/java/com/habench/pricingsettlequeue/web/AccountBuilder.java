package com.habench.pricingsettlequeue.web;

import com.habench.pricingsettlequeue.web.VoucherPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountBuilder {
    private static String cachedCatalog;

    public static void publish(String value) {
        String invoiceKey101 = value;
        String batchTag102 = "ref:" + invoiceKey101 + ";";
        cachedCatalog = batchTag102;
        forward();
    }

    private static void forward() {
        String orderRef103 = cachedCatalog;
        Map<String, String> quoteRef104Attrs = new HashMap<String, String>();
        quoteRef104Attrs.put("channel", "web");
        quoteRef104Attrs.put("payload", orderRef103);
        String quoteRef104 = quoteRef104Attrs.get("payload");
        cachedCatalog = quoteRef104;
        merge();
    }

    private static void merge() {
        String tariffRef105 = cachedCatalog;
        String ledgerEntry106 = "ref:" + tariffRef105 + ";";
        VoucherPolicySelector.forward(ledgerEntry106);
    }
}
