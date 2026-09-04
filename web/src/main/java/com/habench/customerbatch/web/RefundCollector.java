package com.habench.customerbatch.web;

import com.habench.customerbatch.web.VoucherComposer;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {
    private static String cachedBatch;

    public static void assemble(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        String accountRef2 = receiptKey1;
        cachedBatch = accountRef2;
        prepare();
    }

    private static void prepare() {
        String voucherRef3 = cachedBatch;
        String paymentTag4 = "ref:" + voucherRef3 + ";";
        cachedBatch = paymentTag4;
        expand();
    }

    private static void expand() {
        String refundCode5 = cachedBatch;
        Map<String, String> shipmentCode6Attrs = new HashMap<String, String>();
        shipmentCode6Attrs.put("channel", "web");
        shipmentCode6Attrs.put("payload", refundCode5);
        String shipmentCode6 = shipmentCode6Attrs.get("payload");
        VoucherComposer.normalize(shipmentCode6);
    }
}
