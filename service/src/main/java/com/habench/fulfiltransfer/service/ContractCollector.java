package com.habench.fulfiltransfer.service;

import com.habench.fulfiltransfer.service.TariffAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ContractCollector {
    private static String cachedBundle;

    public static void dispatch(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        cachedBundle = receiptKey201;
        refine();
    }

    private static void refine() {
        String accountRef202 = cachedBundle;
        String voucherRef203 = "ref:" + accountRef202 + ";";
        String paymentTag204 = "ref:" + voucherRef203 + ";";
        TariffAdapter.merge(paymentTag204);
    }
}
