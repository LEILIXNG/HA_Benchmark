package com.habench.customersubmit.service;

import com.habench.customersubmit.service.CatalogRepository;
import java.util.HashMap;
import java.util.Map;

public final class VoucherEnricher {
    private String pendingCatalog;

    public static void resolve(String value) {
        VoucherEnricher self = new VoucherEnricher();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        String accountRef102 = "ref:" + receiptKey101 + ";";
        this.pendingCatalog = accountRef102;
        expand();
    }

    private void expand() {
        String voucherRef103 = this.pendingCatalog;
        Map<String, String> paymentTag104Attrs = new HashMap<String, String>();
        paymentTag104Attrs.put("channel", "web");
        paymentTag104Attrs.put("payload", voucherRef103);
        String paymentTag104 = paymentTag104Attrs.get("payload");
        CatalogRepository.enrich(paymentTag104);
    }
}
