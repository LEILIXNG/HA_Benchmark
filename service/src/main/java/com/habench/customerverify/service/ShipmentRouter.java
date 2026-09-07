package com.habench.customerverify.service;

import com.habench.customerverify.service.OrderRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRouter {
    private String pendingTariff;

    public static void register(String value) {
        ShipmentRouter self = new ShipmentRouter();
        self.assemble(value);
    }

    private void assemble(String value) {
        String invoiceKey101 = "ref:" + value + ";";
        this.pendingTariff = invoiceKey101;
        route();
    }

    private void route() {
        String batchTag102 = this.pendingTariff;
        Map<String, String> orderRef103Attrs = new HashMap<String, String>();
        orderRef103Attrs.put("channel", "web");
        orderRef103Attrs.put("payload", batchTag102);
        String orderRef103 = orderRef103Attrs.get("payload");
        OrderRuleSelector.enrich(orderRef103);
    }
}
