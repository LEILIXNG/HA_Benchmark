package com.habench.accountrollup.service;

import com.habench.accountrollup.service.RefundStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountBroker {
    private String pendingBatch;

    public static void prepare(String value) {
        AccountBroker self = new AccountBroker();
        self.publish(value);
    }

    private void publish(String value) {
        String manifestKey201 = value;
        Map<String, String> invoiceKey202Attrs = new HashMap<String, String>();
        invoiceKey202Attrs.put("channel", "web");
        invoiceKey202Attrs.put("payload", manifestKey201);
        String invoiceKey202 = invoiceKey202Attrs.get("payload");
        this.pendingBatch = invoiceKey202;
        stage();
    }

    private void stage() {
        String batchTag203 = this.pendingBatch;
        String orderRef204 = batchTag203;
        RefundStrategySelector.compose(orderRef204);
    }
}
