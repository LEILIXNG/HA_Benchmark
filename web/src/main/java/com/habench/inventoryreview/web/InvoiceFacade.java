package com.habench.inventoryreview.web;

import com.habench.inventoryreview.service.RefundBuilder;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceFacade {
    private static String cachedAccount;

    public static void refine(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("payload", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("payload");
        cachedAccount = channelTag2;
        stage();
    }

    private static void stage() {
        String catalogKey3 = cachedAccount;
        String receiptKey4 = "ref:" + catalogKey3 + ";";
        cachedAccount = receiptKey4;
        route();
    }

    private static void route() {
        String accountRef5 = cachedAccount;
        String voucherRef6 = "ref:" + accountRef5 + ";";
        String paymentTag7 = voucherRef6;
        RefundBuilder.forward(paymentTag7);
    }
}
