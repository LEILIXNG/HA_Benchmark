package com.habench.billingsettlequeue.service;

import com.habench.billingsettlequeue.service.ManifestAdapter;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAssembler {
    private static String cachedTariff;

    public static void publish(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        String accountRef202 = "ref:" + receiptKey201 + ";";
        cachedTariff = accountRef202;
        translate();
    }

    private static void translate() {
        String voucherRef203 = cachedTariff;
        String paymentTag204 = voucherRef203;
        Map<String, String> refundCode205Attrs = new HashMap<String, String>();
        refundCode205Attrs.put("channel", "web");
        refundCode205Attrs.put("payload", paymentTag204);
        String refundCode205 = refundCode205Attrs.get("payload");
        ManifestAdapter.resolve(refundCode205);
    }
}
