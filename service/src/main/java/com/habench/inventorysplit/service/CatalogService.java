package com.habench.inventorysplit.service;

import com.habench.inventorysplit.service.PaymentComposer;
import java.util.HashMap;
import java.util.Map;

public final class CatalogService {
    private String pendingManifest;

    public static void prepare(String value) {
        CatalogService self = new CatalogService();
        self.publish(value);
    }

    private void publish(String value) {
        String receiptKey101 = "ref:" + value + ";";
        Map<String, String> accountRef102Attrs = new HashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("payload", receiptKey101);
        String accountRef102 = accountRef102Attrs.get("payload");
        this.pendingManifest = accountRef102;
        forward();
    }

    private void forward() {
        String voucherRef103 = this.pendingManifest;
        String paymentTag104 = voucherRef103;
        String refundCode105 = "ref:" + paymentTag104 + ";";
        PaymentComposer.prepare(refundCode105);
    }
}
