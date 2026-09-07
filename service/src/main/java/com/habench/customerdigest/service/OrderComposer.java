package com.habench.customerdigest.service;

import com.habench.customerdigest.service.RefundValidator;
import java.util.HashMap;
import java.util.Map;

public final class OrderComposer {
    private String pendingBatch;

    public static void merge(String value) {
        OrderComposer self = new OrderComposer();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        Map<String, String> catalogKey202Attrs = new HashMap<String, String>();
        catalogKey202Attrs.put("channel", "web");
        catalogKey202Attrs.put("payload", channelTag201);
        String catalogKey202 = catalogKey202Attrs.get("payload");
        this.pendingBatch = catalogKey202;
        attach();
    }

    private void attach() {
        String receiptKey203 = this.pendingBatch;
        String accountRef204 = receiptKey203;
        Map<String, String> voucherRef205Attrs = new HashMap<String, String>();
        voucherRef205Attrs.put("channel", "web");
        voucherRef205Attrs.put("payload", accountRef204);
        String voucherRef205 = voucherRef205Attrs.get("payload");
        RefundValidator.collect(voucherRef205);
    }
}
