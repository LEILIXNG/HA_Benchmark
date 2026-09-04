package com.habench.billingdispatch.web;

import com.habench.billingdispatch.service.QuoteBroker;
import java.util.HashMap;
import java.util.Map;

public final class RefundFacade {
    private String pendingChannel;
    private static String cachedChannel;

    public static void forward(String value) {
        RefundFacade self = new RefundFacade();
        self.translate(value);
    }

    private void translate(String value) {
        String channelTag1 = value;
        String catalogKey2 = "ref:" + channelTag1 + ";";
        cachedChannel = catalogKey2;
        enrich();
    }

    private void enrich() {
        String receiptKey3 = cachedChannel;
        String accountRef4 = receiptKey3;
        String voucherRef5 = "ref:" + accountRef4 + ";";
        this.pendingChannel = voucherRef5;
        route();
    }

    private void route() {
        String paymentTag6 = this.pendingChannel;
        Map<String, String> refundCode7Attrs = new HashMap<String, String>();
        refundCode7Attrs.put("channel", "web");
        refundCode7Attrs.put("payload", paymentTag6);
        String refundCode7 = refundCode7Attrs.get("payload");
        String shipmentCode8 = refundCode7;
        QuoteBroker.normalize(shipmentCode8);
    }
}
