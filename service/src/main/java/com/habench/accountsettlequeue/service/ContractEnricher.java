package com.habench.accountsettlequeue.service;

import com.habench.accountsettlequeue.service.InvoiceGuard;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {
    private String pendingManifest;

    public static void enrich(String value) {
        ContractEnricher self = new ContractEnricher();
        self.submit(value);
    }

    private void submit(String value) {
        Map<String, String> receiptKey301Attrs = new HashMap<String, String>();
        receiptKey301Attrs.put("channel", "web");
        receiptKey301Attrs.put("payload", value);
        String receiptKey301 = receiptKey301Attrs.get("payload");
        Map<String, String> accountRef302Attrs = new HashMap<String, String>();
        accountRef302Attrs.put("channel", "web");
        accountRef302Attrs.put("payload", receiptKey301);
        String accountRef302 = accountRef302Attrs.get("payload");
        this.pendingManifest = accountRef302;
        forward();
    }

    private void forward() {
        String voucherRef303 = this.pendingManifest;
        String paymentTag304 = voucherRef303;
        InvoiceGuard.refine(paymentTag304);
    }
}
