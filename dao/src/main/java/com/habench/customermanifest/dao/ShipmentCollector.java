package com.habench.customermanifest.dao;

import com.habench.customermanifest.dao.VoucherScreen;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCollector {

    public static void enrich(String value) {
        Map<String, String> receiptKey501Attrs = new HashMap<String, String>();
        receiptKey501Attrs.put("channel", "web");
        receiptKey501Attrs.put("payload", value);
        String receiptKey501 = receiptKey501Attrs.get("payload");
        String accountRef502 = receiptKey501;
        VoucherScreen.refine(accountRef502);
    }
}
