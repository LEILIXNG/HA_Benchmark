package com.habench.vendorledger.service;

import com.habench.vendorledger.service.ReceiptResolver;
import java.util.HashMap;
import java.util.Map;

public final class BatchBroker {
    private String pendingBatch;

    public static void reconcile(String value) {
        BatchBroker self = new BatchBroker();
        self.prepare(value);
    }

    private void prepare(String value) {
        String accountRef101 = "ref:" + value + ";";
        Map<String, String> voucherRef102Attrs = new HashMap<String, String>();
        voucherRef102Attrs.put("channel", "web");
        voucherRef102Attrs.put("payload", accountRef101);
        String voucherRef102 = voucherRef102Attrs.get("payload");
        this.pendingBatch = voucherRef102;
        dispatch();
    }

    private void dispatch() {
        String paymentTag103 = this.pendingBatch;
        String refundCode104 = "ref:" + paymentTag103 + ";";
        String shipmentCode105 = "ref:" + refundCode104 + ";";
        ReceiptResolver.dispatch(shipmentCode105);
    }
}
