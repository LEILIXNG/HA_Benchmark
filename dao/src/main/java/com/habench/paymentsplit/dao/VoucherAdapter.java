package com.habench.paymentsplit.dao;

import com.habench.paymentsplit.dao.LedgerRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAdapter {
    private String pendingRefund;

    public static void collect(String value) {
        VoucherAdapter self = new VoucherAdapter();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> paymentTag401Attrs = new HashMap<String, String>();
        paymentTag401Attrs.put("channel", "web");
        paymentTag401Attrs.put("payload", value);
        String paymentTag401 = paymentTag401Attrs.get("payload");
        this.pendingRefund = paymentTag401;
        reconcile();
    }

    private void reconcile() {
        String refundCode402 = this.pendingRefund;
        String shipmentCode403 = refundCode402;
        LedgerRuleSelector.publish(shipmentCode403);
    }
}
