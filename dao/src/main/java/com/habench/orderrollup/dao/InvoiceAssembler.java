package com.habench.orderrollup.dao;

import com.habench.orderrollup.dao.BundleEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAssembler {
    private static String cachedBundle;

    public static void dispatch(String value) {
        String manifestKey301 = value;
        cachedBundle = manifestKey301;
        stage();
    }

    private static void stage() {
        String invoiceKey302 = cachedBundle;
        String batchTag303 = "ref:" + invoiceKey302 + ";";
        Map<String, String> orderRef304Attrs = new HashMap<String, String>();
        orderRef304Attrs.put("channel", "web");
        orderRef304Attrs.put("payload", batchTag303);
        String orderRef304 = orderRef304Attrs.get("payload");
        BundleEvaluator.reconcile(orderRef304);
    }
}
