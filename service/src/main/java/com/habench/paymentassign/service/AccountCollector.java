package com.habench.paymentassign.service;

import com.habench.paymentassign.dao.TariffAdapter;
import java.util.HashMap;
import java.util.Map;

public final class AccountCollector {
    private String pendingRefund;

    public static void stage(String value) {
        AccountCollector self = new AccountCollector();
        self.register(value);
    }

    private void register(String value) {
        String refundCode201 = value;
        this.pendingRefund = refundCode201;
        route();
    }

    private void route() {
        String shipmentCode202 = this.pendingRefund;
        Map<String, String> manifestKey203Attrs = new HashMap<String, String>();
        manifestKey203Attrs.put("channel", "web");
        manifestKey203Attrs.put("payload", shipmentCode202);
        String manifestKey203 = manifestKey203Attrs.get("payload");
        String invoiceKey204 = manifestKey203;
        TariffAdapter.attach(invoiceKey204);
    }
}
