package com.habench.fulfilsubmit.dao;

import com.habench.fulfilsubmit.dao.ReceiptEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCoordinator {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void stage(String value) {
        ShipmentCoordinator self = new ShipmentCoordinator();
        self.publish(value);
    }

    private void publish(String value) {
        String ledgerEntry201 = value;
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        cachedReceipt = channelTag202;
        dispatch();
    }

    private void dispatch() {
        String catalogKey203 = cachedReceipt;
        String receiptKey204 = catalogKey203;
        String accountRef205 = "ref:" + receiptKey204 + ";";
        this.pendingReceipt = accountRef205;
        normalize();
    }

    private void normalize() {
        String voucherRef206 = this.pendingReceipt;
        String paymentTag207 = "ref:" + voucherRef206 + ";";
        String refundCode208 = paymentTag207;
        ReceiptEvaluator.dispatch(refundCode208);
    }
}
