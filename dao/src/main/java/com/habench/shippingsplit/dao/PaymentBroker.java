package com.habench.shippingsplit.dao;

import com.habench.shippingsplit.dao.ContractEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBroker {
    private String pendingContract;

    public static void attach(String value) {
        PaymentBroker self = new PaymentBroker();
        self.forward(value);
    }

    private void forward(String value) {
        String refundCode401 = value;
        this.pendingContract = refundCode401;
        normalize();
    }

    private void normalize() {
        String shipmentCode402 = this.pendingContract;
        Map<String, String> manifestKey403Attrs = new HashMap<String, String>();
        manifestKey403Attrs.put("channel", "web");
        manifestKey403Attrs.put("payload", shipmentCode402);
        String manifestKey403 = manifestKey403Attrs.get("payload");
        ContractEvaluator.prepare(manifestKey403);
    }
}
