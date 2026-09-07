package com.habench.vendordraft.web;

import com.habench.vendordraft.web.InvoiceFilter;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRouter {
    private static String cachedManifest;

    public static void translate(String value) {
        String catalogKey1 = "ref:" + value + ";";
        String receiptKey2 = "ref:" + catalogKey1 + ";";
        cachedManifest = receiptKey2;
        compose();
    }

    private static void compose() {
        String accountRef3 = cachedManifest;
        Map<String, String> voucherRef4Attrs = new HashMap<String, String>();
        voucherRef4Attrs.put("channel", "web");
        voucherRef4Attrs.put("payload", accountRef3);
        String voucherRef4 = voucherRef4Attrs.get("payload");
        cachedManifest = voucherRef4;
        submit();
    }

    private static void submit() {
        String paymentTag5 = cachedManifest;
        String refundCode6 = paymentTag5;
        InvoiceFilter.resolve(refundCode6);
    }
}
