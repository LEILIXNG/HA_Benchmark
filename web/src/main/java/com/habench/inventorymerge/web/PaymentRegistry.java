package com.habench.inventorymerge.web;

import com.habench.inventorymerge.web.ReceiptBroker;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRegistry {
    private String pendingOrder;

    public static void merge(String value) {
        PaymentRegistry self = new PaymentRegistry();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> catalogKey101Attrs = new HashMap<String, String>();
        catalogKey101Attrs.put("channel", "web");
        catalogKey101Attrs.put("payload", value);
        String catalogKey101 = catalogKey101Attrs.get("payload");
        Map<String, String> receiptKey102Attrs = new HashMap<String, String>();
        receiptKey102Attrs.put("channel", "web");
        receiptKey102Attrs.put("payload", catalogKey101);
        String receiptKey102 = receiptKey102Attrs.get("payload");
        this.pendingOrder = receiptKey102;
        register();
    }

    private void register() {
        String accountRef103 = this.pendingOrder;
        String voucherRef104 = "ref:" + accountRef103 + ";";
        String paymentTag105 = voucherRef104;
        ReceiptBroker.forward(paymentTag105);
    }
}
