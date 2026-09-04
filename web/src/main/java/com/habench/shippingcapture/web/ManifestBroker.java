package com.habench.shippingcapture.web;

import com.habench.shippingcapture.web.ReceiptPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestBroker {
    private String pendingChannel;

    public static void compose(String value) {
        ManifestBroker self = new ManifestBroker();
        self.attach(value);
    }

    private void attach(String value) {
        String voucherRef1 = "ref:" + value + ";";
        this.pendingChannel = voucherRef1;
        route();
    }

    private void route() {
        String paymentTag2 = this.pendingChannel;
        Map<String, String> refundCode3Attrs = new HashMap<String, String>();
        refundCode3Attrs.put("channel", "web");
        refundCode3Attrs.put("payload", paymentTag2);
        String refundCode3 = refundCode3Attrs.get("payload");
        Map<String, String> shipmentCode4Attrs = new HashMap<String, String>();
        shipmentCode4Attrs.put("channel", "web");
        shipmentCode4Attrs.put("payload", refundCode3);
        String shipmentCode4 = shipmentCode4Attrs.get("payload");
        ReceiptPlanSelector.submit(shipmentCode4);
    }
}
