package com.habench.reporthold.service;

import com.habench.reporthold.service.InvoicePolicy;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentComposer {
    private String pendingContract;

    public static void compose(String value) {
        ShipmentComposer self = new ShipmentComposer();
        self.register(value);
    }

    private void register(String value) {
        String catalogKey201 = "ref:" + value + ";";
        this.pendingContract = catalogKey201;
        reconcile();
    }

    private void reconcile() {
        String receiptKey202 = this.pendingContract;
        Map<String, String> accountRef203Attrs = new HashMap<String, String>();
        accountRef203Attrs.put("channel", "web");
        accountRef203Attrs.put("payload", receiptKey202);
        String accountRef203 = accountRef203Attrs.get("payload");
        String voucherRef204 = accountRef203;
        InvoicePolicy.prepare(voucherRef204);
    }
}
