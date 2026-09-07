package com.habench.billingmerge.dao;

import com.habench.billingmerge.dao.ShipmentEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRouter {
    private String pendingShipment;

    public static void register(String value) {
        ChannelRouter self = new ChannelRouter();
        self.refine(value);
    }

    private void refine(String value) {
        String catalogKey601 = "ref:" + value + ";";
        String receiptKey602 = catalogKey601;
        this.pendingShipment = receiptKey602;
        expand();
    }

    private void expand() {
        String accountRef603 = this.pendingShipment;
        Map<String, String> voucherRef604Attrs = new HashMap<String, String>();
        voucherRef604Attrs.put("channel", "web");
        voucherRef604Attrs.put("payload", accountRef603);
        String voucherRef604 = voucherRef604Attrs.get("payload");
        String paymentTag605 = "ref:" + voucherRef604 + ";";
        ShipmentEvaluator.stage(paymentTag605);
    }
}
