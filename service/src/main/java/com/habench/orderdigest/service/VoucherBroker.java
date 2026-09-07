package com.habench.orderdigest.service;

import com.habench.orderdigest.service.RefundEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBroker {
    private String pendingRefund;

    public static void normalize(String value) {
        VoucherBroker self = new VoucherBroker();
        self.enrich(value);
    }

    private void enrich(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        this.pendingRefund = invoiceKey201;
        register();
    }

    private void register() {
        String batchTag202 = this.pendingRefund;
        Map<String, String> orderRef203Attrs = new HashMap<String, String>();
        orderRef203Attrs.put("channel", "web");
        orderRef203Attrs.put("payload", batchTag202);
        String orderRef203 = orderRef203Attrs.get("payload");
        String quoteRef204 = orderRef203;
        RefundEvaluator.stage(quoteRef204);
    }
}
