package com.habench.fulfilissue.service;

import com.habench.fulfilissue.service.LedgerStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherNormalizer {
    private String pendingContract;

    public static void attach(String value) {
        VoucherNormalizer self = new VoucherNormalizer();
        self.enrich(value);
    }

    private void enrich(String value) {
        String manifestKey201 = value;
        this.pendingContract = manifestKey201;
        publish();
    }

    private void publish() {
        String invoiceKey202 = this.pendingContract;
        String batchTag203 = "ref:" + invoiceKey202 + ";";
        Map<String, String> orderRef204Attrs = new HashMap<String, String>();
        orderRef204Attrs.put("channel", "web");
        orderRef204Attrs.put("payload", batchTag203);
        String orderRef204 = orderRef204Attrs.get("payload");
        LedgerStrategySelector.stage(orderRef204);
    }
}
