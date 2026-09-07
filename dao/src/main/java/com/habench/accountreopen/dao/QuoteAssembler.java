package com.habench.accountreopen.dao;

import com.habench.accountreopen.dao.VoucherStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAssembler {
    private String pendingSession;

    public static void assemble(String value) {
        QuoteAssembler self = new QuoteAssembler();
        self.resolve(value);
    }

    private void resolve(String value) {
        String voucherRef401 = value;
        this.pendingSession = voucherRef401;
        dispatch();
    }

    private void dispatch() {
        String paymentTag402 = this.pendingSession;
        String refundCode403 = paymentTag402;
        Map<String, String> shipmentCode404Attrs = new HashMap<String, String>();
        shipmentCode404Attrs.put("channel", "web");
        shipmentCode404Attrs.put("payload", refundCode403);
        String shipmentCode404 = shipmentCode404Attrs.get("payload");
        VoucherStrategySelector.collect(shipmentCode404);
    }
}
