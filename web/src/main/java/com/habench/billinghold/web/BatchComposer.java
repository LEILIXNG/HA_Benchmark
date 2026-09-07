package com.habench.billinghold.web;

import com.habench.billinghold.service.ContractRouter;
import java.util.HashMap;
import java.util.Map;

public final class BatchComposer {
    private static String cachedReceipt;

    public static void dispatch(String value) {
        String manifestKey1 = "ref:" + value + ";";
        String invoiceKey2 = manifestKey1;
        cachedReceipt = invoiceKey2;
        prepare();
    }

    private static void prepare() {
        String batchTag3 = cachedReceipt;
        String orderRef4 = batchTag3;
        Map<String, String> quoteRef5Attrs = new HashMap<String, String>();
        quoteRef5Attrs.put("channel", "web");
        quoteRef5Attrs.put("payload", orderRef4);
        String quoteRef5 = quoteRef5Attrs.get("payload");
        ContractRouter.attach(quoteRef5);
    }
}
