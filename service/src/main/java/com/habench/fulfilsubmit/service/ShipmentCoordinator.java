package com.habench.fulfilsubmit.service;

import com.habench.fulfilsubmit.service.ReceiptEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCoordinator {
    private String pendingReceipt;

    public static void stage(String value) {
        ShipmentCoordinator self = new ShipmentCoordinator();
        self.publish(value);
    }

    private void publish(String value) {
        String ledgerEntry201 = value;
        this.pendingReceipt = ledgerEntry201;
        dispatch();
    }

    private void dispatch() {
        String channelTag202 = this.pendingReceipt;
        String catalogKey203 = channelTag202;
        String receiptKey204 = "ref:" + catalogKey203 + ";";
        this.pendingReceipt = receiptKey204;
        normalize();
    }

    private void normalize() {
        String accountRef205 = this.pendingReceipt;
        String voucherRef206 = "ref:" + accountRef205 + ";";
        Map<String, String> paymentTag207Attrs = new HashMap<String, String>();
        paymentTag207Attrs.put("channel", "web");
        paymentTag207Attrs.put("payload", voucherRef206);
        String paymentTag207 = paymentTag207Attrs.get("payload");
        ReceiptEvaluator.dispatch(paymentTag207);
    }
}
