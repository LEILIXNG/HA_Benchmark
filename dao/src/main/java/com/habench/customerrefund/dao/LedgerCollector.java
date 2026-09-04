package com.habench.customerrefund.dao;

import com.habench.customerrefund.dao.TariffExecutor;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCollector {
    private String pendingTariff;

    public static void forward(String value) {
        LedgerCollector self = new LedgerCollector();
        self.register(value);
    }

    private void register(String value) {
        String voucherRef401 = value;
        this.pendingTariff = voucherRef401;
        refine();
    }

    private void refine() {
        String paymentTag402 = this.pendingTariff;
        Map<String, String> refundCode403Attrs = new HashMap<String, String>();
        refundCode403Attrs.put("channel", "web");
        refundCode403Attrs.put("payload", paymentTag402);
        String refundCode403 = refundCode403Attrs.get("payload");
        Map<String, String> shipmentCode404Attrs = new HashMap<String, String>();
        shipmentCode404Attrs.put("channel", "web");
        shipmentCode404Attrs.put("payload", refundCode403);
        String shipmentCode404 = shipmentCode404Attrs.get("payload");
        TariffExecutor.translate(shipmentCode404);
    }
}
