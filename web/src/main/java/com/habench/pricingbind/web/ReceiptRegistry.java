package com.habench.pricingbind.web;

import com.habench.pricingbind.web.BundlePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRegistry {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void stage(String value) {
        ReceiptRegistry self = new ReceiptRegistry();
        self.normalize(value);
    }

    private void normalize(String value) {
        String manifestKey1 = value;
        cachedReceipt = manifestKey1;
        forward();
    }

    private void forward() {
        String invoiceKey2 = cachedReceipt;
        String batchTag3 = "ref:" + invoiceKey2 + ";";
        cachedReceipt = batchTag3;
        submit();
    }

    private void submit() {
        String orderRef4 = cachedReceipt;
        Map<String, String> quoteRef5Attrs = new HashMap<String, String>();
        quoteRef5Attrs.put("channel", "web");
        quoteRef5Attrs.put("payload", orderRef4);
        String quoteRef5 = quoteRef5Attrs.get("payload");
        this.pendingReceipt = quoteRef5;
        resolve();
    }

    private void resolve() {
        String tariffRef6 = this.pendingReceipt;
        String ledgerEntry7 = tariffRef6;
        Map<String, String> channelTag8Attrs = new HashMap<String, String>();
        channelTag8Attrs.put("channel", "web");
        channelTag8Attrs.put("payload", ledgerEntry7);
        String channelTag8 = channelTag8Attrs.get("payload");
        BundlePlanSelector.reconcile(channelTag8);
    }
}
