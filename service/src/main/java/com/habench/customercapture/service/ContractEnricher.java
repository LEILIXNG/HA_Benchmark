package com.habench.customercapture.service;

import com.habench.customercapture.dao.BatchNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {
    private String pendingRefund;

    public static void forward(String value) {
        ContractEnricher self = new ContractEnricher();
        self.submit(value);
    }

    private void submit(String value) {
        String ledgerEntry201 = value;
        this.pendingRefund = ledgerEntry201;
        collect();
    }

    private void collect() {
        String channelTag202 = this.pendingRefund;
        String catalogKey203 = channelTag202;
        Map<String, String> receiptKey204Attrs = new HashMap<String, String>();
        receiptKey204Attrs.put("channel", "web");
        receiptKey204Attrs.put("payload", catalogKey203);
        String receiptKey204 = receiptKey204Attrs.get("payload");
        BatchNormalizer.submit(receiptKey204);
    }
}
