package com.habench.inventoryassign.web;

import com.habench.inventoryassign.service.InvoiceRegistry;
import java.util.HashMap;
import java.util.Map;

public final class TariffRouter {
    private String pendingManifest;

    public static void translate(String value) {
        TariffRouter self = new TariffRouter();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> receiptKey1Attrs = new HashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("payload", value);
        String receiptKey1 = receiptKey1Attrs.get("payload");
        this.pendingManifest = receiptKey1;
        resolve();
    }

    private void resolve() {
        String accountRef2 = this.pendingManifest;
        String voucherRef3 = accountRef2;
        String paymentTag4 = voucherRef3;
        InvoiceRegistry.compose(paymentTag4);
    }
}
