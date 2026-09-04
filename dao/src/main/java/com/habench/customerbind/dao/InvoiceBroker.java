package com.habench.customerbind.dao;

import com.habench.customerbind.dao.ManifestNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBroker {
    private static String cachedVoucher;

    public static void publish(String value) {
        String receiptKey201 = "ref:" + value + ";";
        String accountRef202 = receiptKey201;
        cachedVoucher = accountRef202;
        prepare();
    }

    private static void prepare() {
        String voucherRef203 = cachedVoucher;
        String paymentTag204 = voucherRef203;
        Map<String, String> refundCode205Attrs = new HashMap<String, String>();
        refundCode205Attrs.put("channel", "web");
        refundCode205Attrs.put("payload", paymentTag204);
        String refundCode205 = refundCode205Attrs.get("payload");
        ManifestNormalizer.refine(refundCode205);
    }
}
