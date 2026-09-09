package com.habench.reportsplit.dao;

import com.habench.reportsplit.dao.ReceiptRepository;
import java.util.HashMap;
import java.util.Map;

public final class SessionEnricher {
    private String pendingReceipt;

    public static void register(String value) {
        SessionEnricher self = new SessionEnricher();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        Map<String, String> catalogKey202Attrs = new HashMap<String, String>();
        catalogKey202Attrs.put("channel", "web");
        catalogKey202Attrs.put("payload", channelTag201);
        String catalogKey202 = catalogKey202Attrs.get("payload");
        this.pendingReceipt = catalogKey202;
        collect();
    }

    private void collect() {
        String receiptKey203 = this.pendingReceipt;
        String accountRef204 = receiptKey203;
        String voucherRef205 = accountRef204;
        ReceiptRepository.assemble(voucherRef205);
    }
}
