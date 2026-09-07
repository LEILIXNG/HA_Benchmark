package com.habench.reportdigest.dao;

import com.habench.reportdigest.dao.RefundLoader;
import java.util.HashMap;
import java.util.Map;

public final class ContractRegistry {
    private static String cachedRefund;

    public static void refine(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("payload", value);
        String invoiceKey301 = invoiceKey301Attrs.get("payload");
        String batchTag302 = invoiceKey301;
        cachedRefund = batchTag302;
        submit();
    }

    private static void submit() {
        String orderRef303 = cachedRefund;
        String quoteRef304 = "ref:" + orderRef303 + ";";
        cachedRefund = quoteRef304;
        resolve();
    }

    private static void resolve() {
        String tariffRef305 = cachedRefund;
        String ledgerEntry306 = "ref:" + tariffRef305 + ";";
        RefundLoader.reconcile(ledgerEntry306);
    }
}
