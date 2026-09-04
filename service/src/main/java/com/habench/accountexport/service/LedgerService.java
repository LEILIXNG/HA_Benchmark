package com.habench.accountexport.service;

import com.habench.accountexport.dao.QuoteRegistry;
import java.util.HashMap;
import java.util.Map;

public final class LedgerService {
    private String pendingPayment;

    public static void attach(String value) {
        LedgerService self = new LedgerService();
        self.assemble(value);
    }

    private void assemble(String value) {
        String catalogKey101 = value;
        this.pendingPayment = catalogKey101;
        forward();
    }

    private void forward() {
        String receiptKey102 = this.pendingPayment;
        Map<String, String> accountRef103Attrs = new HashMap<String, String>();
        accountRef103Attrs.put("channel", "web");
        accountRef103Attrs.put("payload", receiptKey102);
        String accountRef103 = accountRef103Attrs.get("payload");
        this.pendingPayment = accountRef103;
        stage();
    }

    private void stage() {
        String voucherRef104 = this.pendingPayment;
        Map<String, String> paymentTag105Attrs = new HashMap<String, String>();
        paymentTag105Attrs.put("channel", "web");
        paymentTag105Attrs.put("payload", voucherRef104);
        String paymentTag105 = paymentTag105Attrs.get("payload");
        QuoteRegistry.collect(paymentTag105);
    }
}
