package com.habench.reportbatch.web;

import com.habench.reportbatch.web.ContractPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptAssembler2 {
    private static String cachedBundle;

    public static void submit(String value) {
        String accountRef1 = value;
        cachedBundle = accountRef1;
        register();
    }

    private static void register() {
        String voucherRef2 = cachedBundle;
        Map<String, String> paymentTag3Attrs = new HashMap<String, String>();
        paymentTag3Attrs.put("channel", "web");
        paymentTag3Attrs.put("payload", voucherRef2);
        String paymentTag3 = paymentTag3Attrs.get("payload");
        cachedBundle = paymentTag3;
        dispatch();
    }

    private static void dispatch() {
        String refundCode4 = cachedBundle;
        Map<String, String> shipmentCode5Attrs = new HashMap<String, String>();
        shipmentCode5Attrs.put("channel", "web");
        shipmentCode5Attrs.put("payload", refundCode4);
        String shipmentCode5 = shipmentCode5Attrs.get("payload");
        ContractPlanSelector.forward(shipmentCode5);
    }
}
