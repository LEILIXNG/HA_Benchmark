package com.habench.fulfilreview.web;

import com.habench.fulfilreview.web.OrderExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBuilder {
    private String pendingOrder;
    private static String cachedOrder;

    public static void register(String value) {
        ChannelBuilder self = new ChannelBuilder();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        cachedOrder = accountRef1;
        collect();
    }

    private void collect() {
        String voucherRef2 = cachedOrder;
        String paymentTag3 = "ref:" + voucherRef2 + ";";
        cachedOrder = paymentTag3;
        submit();
    }

    private void submit() {
        String refundCode4 = cachedOrder;
        Map<String, String> shipmentCode5Attrs = new HashMap<String, String>();
        shipmentCode5Attrs.put("channel", "web");
        shipmentCode5Attrs.put("payload", refundCode4);
        String shipmentCode5 = shipmentCode5Attrs.get("payload");
        cachedOrder = shipmentCode5;
        reconcile();
    }

    private void reconcile() {
        String manifestKey6 = cachedOrder;
        Map<String, String> invoiceKey7Attrs = new HashMap<String, String>();
        invoiceKey7Attrs.put("channel", "web");
        invoiceKey7Attrs.put("payload", manifestKey6);
        String invoiceKey7 = invoiceKey7Attrs.get("payload");
        this.pendingOrder = invoiceKey7;
        forward();
    }

    private void forward() {
        String batchTag8 = this.pendingOrder;
        String orderRef9 = batchTag8;
        OrderExecutor.attach(orderRef9);
    }
}
