package com.habench.reportreview.dao;

import com.habench.reportreview.dao.ContractTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCollector {
    private static String cachedSession;

    public static void compose(String value) {
        String accountRef601 = "ref:" + value + ";";
        Map<String, String> voucherRef602Attrs = new HashMap<String, String>();
        voucherRef602Attrs.put("channel", "web");
        voucherRef602Attrs.put("payload", accountRef601);
        String voucherRef602 = voucherRef602Attrs.get("payload");
        cachedSession = voucherRef602;
        reconcile();
    }

    private static void reconcile() {
        String paymentTag603 = cachedSession;
        String refundCode604 = paymentTag603;
        ContractTranslator.prepare(refundCode604);
    }
}
