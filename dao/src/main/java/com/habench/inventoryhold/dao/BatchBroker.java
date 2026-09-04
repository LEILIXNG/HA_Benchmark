package com.habench.inventoryhold.dao;

import com.habench.inventoryhold.dao.AccountCollector;
import java.util.HashMap;
import java.util.Map;

public final class BatchBroker {
    private String pendingBundle;
    private static String cachedBundle;

    public static void forward(String value) {
        BatchBroker self = new BatchBroker();
        self.enrich(value);
    }

    private void enrich(String value) {
        String receiptKey201 = "ref:" + value + ";";
        this.pendingBundle = receiptKey201;
        dispatch();
    }

    private void dispatch() {
        String accountRef202 = this.pendingBundle;
        Map<String, String> voucherRef203Attrs = new HashMap<String, String>();
        voucherRef203Attrs.put("channel", "web");
        voucherRef203Attrs.put("payload", accountRef202);
        String voucherRef203 = voucherRef203Attrs.get("payload");
        cachedBundle = voucherRef203;
        normalize();
    }

    private void normalize() {
        String paymentTag204 = cachedBundle;
        String refundCode205 = "ref:" + paymentTag204 + ";";
        String shipmentCode206 = refundCode205;
        AccountCollector.refine(shipmentCode206);
    }
}
