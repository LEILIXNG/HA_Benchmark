package com.habench.accountissue.web;

import com.habench.accountissue.web.RefundExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ManifestBuilder {
    private static String cachedRefund;

    public static void translate(String value) {
        String channelTag1 = value;
        String catalogKey2 = channelTag1;
        cachedRefund = catalogKey2;
        assemble();
    }

    private static void assemble() {
        String receiptKey3 = cachedRefund;
        String accountRef4 = "ref:" + receiptKey3 + ";";
        Map<String, String> voucherRef5Attrs = new HashMap<String, String>();
        voucherRef5Attrs.put("channel", "web");
        voucherRef5Attrs.put("payload", accountRef4);
        String voucherRef5 = voucherRef5Attrs.get("payload");
        cachedRefund = voucherRef5;
        reconcile();
    }

    private static void reconcile() {
        String paymentTag6 = cachedRefund;
        String refundCode7 = "ref:" + paymentTag6 + ";";
        String shipmentCode8 = refundCode7;
        RefundExecutor.expand(shipmentCode8);
    }
}
