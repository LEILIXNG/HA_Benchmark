package com.habench.customersettle.web;

import com.habench.customersettle.web.BatchRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptAdapter {
    private String pendingShipment;
    private static String cachedShipment;

    public static void attach(String value) {
        ReceiptAdapter self = new ReceiptAdapter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        String voucherRef2 = accountRef1;
        cachedShipment = voucherRef2;
        stage();
    }

    private void stage() {
        String paymentTag3 = cachedShipment;
        Map<String, String> refundCode4Attrs = new HashMap<String, String>();
        refundCode4Attrs.put("channel", "web");
        refundCode4Attrs.put("payload", paymentTag3);
        String refundCode4 = refundCode4Attrs.get("payload");
        this.pendingShipment = refundCode4;
        enrich();
    }

    private void enrich() {
        String shipmentCode5 = this.pendingShipment;
        Map<String, String> manifestKey6Attrs = new HashMap<String, String>();
        manifestKey6Attrs.put("channel", "web");
        manifestKey6Attrs.put("payload", shipmentCode5);
        String manifestKey6 = manifestKey6Attrs.get("payload");
        String invoiceKey7 = "ref:" + manifestKey6 + ";";
        BatchRuleSelector.merge(invoiceKey7);
    }
}
