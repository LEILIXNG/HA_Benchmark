package com.habench.catalogmerge.web;

import com.habench.catalogmerge.service.ContractScreen;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCoordinator {
    private static String cachedChannel;

    public static void stage(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        Map<String, String> receiptKey2Attrs = new HashMap<String, String>();
        receiptKey2Attrs.put("channel", "web");
        receiptKey2Attrs.put("payload", catalogKey1);
        String receiptKey2 = receiptKey2Attrs.get("payload");
        cachedChannel = receiptKey2;
        assemble();
    }

    private static void assemble() {
        String accountRef3 = cachedChannel;
        String voucherRef4 = "ref:" + accountRef3 + ";";
        ContractScreen.collect(voucherRef4);
    }
}
