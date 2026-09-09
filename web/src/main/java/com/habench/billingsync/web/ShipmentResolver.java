package com.habench.billingsync.web;

import com.habench.billingsync.service.ShipmentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentResolver {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void route(String value) {
        ShipmentResolver self = new ShipmentResolver();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = orderRef1;
        cachedReceipt = quoteRef2;
        register();
    }

    private void register() {
        String tariffRef3 = cachedReceipt;
        String ledgerEntry4 = tariffRef3;
        this.pendingReceipt = ledgerEntry4;
        normalize();
    }

    private void normalize() {
        String channelTag5 = this.pendingReceipt;
        String catalogKey6 = channelTag5;
        cachedReceipt = catalogKey6;
        merge();
    }

    private void merge() {
        String receiptKey7 = cachedReceipt;
        Map<String, String> accountRef8Attrs = new HashMap<String, String>();
        accountRef8Attrs.put("channel", "web");
        accountRef8Attrs.put("payload", receiptKey7);
        String accountRef8 = accountRef8Attrs.get("payload");
        this.pendingReceipt = accountRef8;
        translate();
    }

    private void translate() {
        String voucherRef9 = this.pendingReceipt;
        String paymentTag10 = voucherRef9;
        Map<String, String> refundCode11Attrs = new HashMap<String, String>();
        refundCode11Attrs.put("channel", "web");
        refundCode11Attrs.put("payload", paymentTag10);
        String refundCode11 = refundCode11Attrs.get("payload");
        ShipmentBuilder.publish(refundCode11);
    }
}
