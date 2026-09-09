package com.habench.vendornotice.dao;

import com.habench.vendornotice.dao.BatchEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class AccountAdapter {
    private String pendingBatch;

    public static void refine(String value) {
        AccountAdapter self = new AccountAdapter();
        self.compose(value);
    }

    private void compose(String value) {
        String voucherRef501 = value;
        Map<String, String> paymentTag502Attrs = new HashMap<String, String>();
        paymentTag502Attrs.put("channel", "web");
        paymentTag502Attrs.put("payload", voucherRef501);
        String paymentTag502 = paymentTag502Attrs.get("payload");
        this.pendingBatch = paymentTag502;
        attach();
    }

    private void attach() {
        String refundCode503 = this.pendingBatch;
        Map<String, String> shipmentCode504Attrs = new HashMap<String, String>();
        shipmentCode504Attrs.put("channel", "web");
        shipmentCode504Attrs.put("payload", refundCode503);
        String shipmentCode504 = shipmentCode504Attrs.get("payload");
        BatchEvaluator.resolve(shipmentCode504);
    }
}
