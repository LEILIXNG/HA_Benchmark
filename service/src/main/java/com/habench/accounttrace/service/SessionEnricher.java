package com.habench.accounttrace.service;

import com.habench.accounttrace.service.ReceiptBuilder;
import java.util.HashMap;
import java.util.Map;

public final class SessionEnricher {
    private String pendingBatch;
    private static String cachedBatch;

    public static void translate(String value) {
        SessionEnricher self = new SessionEnricher();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        cachedBatch = receiptKey101;
        stage();
    }

    private void stage() {
        String accountRef102 = cachedBatch;
        String voucherRef103 = "ref:" + accountRef102 + ";";
        String paymentTag104 = "ref:" + voucherRef103 + ";";
        this.pendingBatch = paymentTag104;
        submit();
    }

    private void submit() {
        String refundCode105 = this.pendingBatch;
        String shipmentCode106 = "ref:" + refundCode105 + ";";
        ReceiptBuilder.compose(shipmentCode106);
    }
}
