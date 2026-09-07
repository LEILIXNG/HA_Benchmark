package com.habench.orderreview.service;

import com.habench.orderreview.service.SessionExecutor;
import java.util.HashMap;
import java.util.Map;

public final class PaymentComposer {
    private String pendingSession;

    public static void reconcile(String value) {
        PaymentComposer self = new PaymentComposer();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        this.pendingSession = catalogKey201;
        refine();
    }

    private void refine() {
        String receiptKey202 = this.pendingSession;
        Map<String, String> accountRef203Attrs = new HashMap<String, String>();
        accountRef203Attrs.put("channel", "web");
        accountRef203Attrs.put("payload", receiptKey202);
        String accountRef203 = accountRef203Attrs.get("payload");
        Map<String, String> voucherRef204Attrs = new HashMap<String, String>();
        voucherRef204Attrs.put("channel", "web");
        voucherRef204Attrs.put("payload", accountRef203);
        String voucherRef204 = voucherRef204Attrs.get("payload");
        SessionExecutor.attach(voucherRef204);
    }
}
