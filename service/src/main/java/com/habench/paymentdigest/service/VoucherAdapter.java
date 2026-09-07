package com.habench.paymentdigest.service;

import com.habench.paymentdigest.dao.RefundBuilder;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAdapter {
    private String pendingContract;

    public static void translate(String value) {
        VoucherAdapter self = new VoucherAdapter();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> channelTag101Attrs = new HashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("payload", value);
        String channelTag101 = channelTag101Attrs.get("payload");
        this.pendingContract = channelTag101;
        normalize();
    }

    private void normalize() {
        String catalogKey102 = this.pendingContract;
        String receiptKey103 = catalogKey102;
        RefundBuilder.forward(receiptKey103);
    }
}
