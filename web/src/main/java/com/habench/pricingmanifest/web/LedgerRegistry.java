package com.habench.pricingmanifest.web;

import com.habench.pricingmanifest.service.ReceiptComposer;
import java.util.HashMap;
import java.util.Map;

public final class LedgerRegistry {
    private String pendingContract;

    public static void stage(String value) {
        LedgerRegistry self = new LedgerRegistry();
        self.refine(value);
    }

    private void refine(String value) {
        String voucherRef1 = value;
        this.pendingContract = voucherRef1;
        compose();
    }

    private void compose() {
        String paymentTag2 = this.pendingContract;
        String refundCode3 = paymentTag2;
        Map<String, String> shipmentCode4Attrs = new HashMap<String, String>();
        shipmentCode4Attrs.put("channel", "web");
        shipmentCode4Attrs.put("payload", refundCode3);
        String shipmentCode4 = shipmentCode4Attrs.get("payload");
        ReceiptComposer.expand(shipmentCode4);
    }
}
