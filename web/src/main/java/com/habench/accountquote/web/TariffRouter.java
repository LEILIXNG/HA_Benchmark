package com.habench.accountquote.web;

import com.habench.accountquote.service.OrderComposer;
import java.util.HashMap;
import java.util.Map;

public final class TariffRouter {
    private String pendingBatch;

    public static void normalize(String value) {
        TariffRouter self = new TariffRouter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String paymentTag101 = value;
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        this.pendingBatch = refundCode102;
        prepare();
    }

    private void prepare() {
        String shipmentCode103 = this.pendingBatch;
        String manifestKey104 = shipmentCode103;
        this.pendingBatch = manifestKey104;
        dispatch();
    }

    private void dispatch() {
        String invoiceKey105 = this.pendingBatch;
        Map<String, String> batchTag106Attrs = new HashMap<String, String>();
        batchTag106Attrs.put("channel", "web");
        batchTag106Attrs.put("payload", invoiceKey105);
        String batchTag106 = batchTag106Attrs.get("payload");
        OrderComposer.merge(batchTag106);
    }
}
