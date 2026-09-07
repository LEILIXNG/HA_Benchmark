package com.habench.reportimport.dao;

import com.habench.reportimport.dao.ContractStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAdapter {
    private static String cachedBundle;

    public static void prepare(String value) {
        String voucherRef301 = "ref:" + value + ";";
        cachedBundle = voucherRef301;
        collect();
    }

    private static void collect() {
        String paymentTag302 = cachedBundle;
        String refundCode303 = "ref:" + paymentTag302 + ";";
        cachedBundle = refundCode303;
        resolve();
    }

    private static void resolve() {
        String shipmentCode304 = cachedBundle;
        String manifestKey305 = "ref:" + shipmentCode304 + ";";
        Map<String, String> invoiceKey306Attrs = new HashMap<String, String>();
        invoiceKey306Attrs.put("channel", "web");
        invoiceKey306Attrs.put("payload", manifestKey305);
        String invoiceKey306 = invoiceKey306Attrs.get("payload");
        ContractStrategySelector.normalize(invoiceKey306);
    }
}
