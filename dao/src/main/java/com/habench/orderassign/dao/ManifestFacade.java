package com.habench.orderassign.dao;

import com.habench.orderassign.dao.InvoiceNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ManifestFacade {
    private static String cachedReceipt;

    public static void enrich(String value) {
        String channelTag201 = "ref:" + value + ";";
        String catalogKey202 = channelTag201;
        cachedReceipt = catalogKey202;
        forward();
    }

    private static void forward() {
        String receiptKey203 = cachedReceipt;
        String accountRef204 = receiptKey203;
        Map<String, String> voucherRef205Attrs = new HashMap<String, String>();
        voucherRef205Attrs.put("channel", "web");
        voucherRef205Attrs.put("payload", accountRef204);
        String voucherRef205 = voucherRef205Attrs.get("payload");
        InvoiceNormalizer.route(voucherRef205);
    }
}
