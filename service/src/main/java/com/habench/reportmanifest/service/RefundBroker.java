package com.habench.reportmanifest.service;

import com.habench.reportmanifest.service.BundleValidator;
import java.util.HashMap;
import java.util.Map;

public final class RefundBroker {
    private String pendingContract;

    public static void reconcile(String value) {
        RefundBroker self = new RefundBroker();
        self.stage(value);
    }

    private void stage(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        this.pendingContract = ledgerEntry201;
        assemble();
    }

    private void assemble() {
        String channelTag202 = this.pendingContract;
        String catalogKey203 = "ref:" + channelTag202 + ";";
        this.pendingContract = catalogKey203;
        register();
    }

    private void register() {
        String receiptKey204 = this.pendingContract;
        String accountRef205 = "ref:" + receiptKey204 + ";";
        String voucherRef206 = "ref:" + accountRef205 + ";";
        this.pendingContract = voucherRef206;
        normalize();
    }

    private void normalize() {
        String paymentTag207 = this.pendingContract;
        String refundCode208 = paymentTag207;
        Map<String, String> shipmentCode209Attrs = new HashMap<String, String>();
        shipmentCode209Attrs.put("channel", "web");
        shipmentCode209Attrs.put("payload", refundCode208);
        String shipmentCode209 = shipmentCode209Attrs.get("payload");
        BundleValidator.attach(shipmentCode209);
    }
}
