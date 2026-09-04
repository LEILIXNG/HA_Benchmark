package com.habench.paymentsettle.web;

import com.habench.paymentsettle.web.QuotePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestComposer {
    private String pendingTariff;

    public static void attach(String value) {
        ManifestComposer self = new ManifestComposer();
        self.submit(value);
    }

    private void submit(String value) {
        String voucherRef201 = value;
        Map<String, String> paymentTag202Attrs = new HashMap<String, String>();
        paymentTag202Attrs.put("channel", "web");
        paymentTag202Attrs.put("payload", voucherRef201);
        String paymentTag202 = paymentTag202Attrs.get("payload");
        this.pendingTariff = paymentTag202;
        collect();
    }

    private void collect() {
        String refundCode203 = this.pendingTariff;
        Map<String, String> shipmentCode204Attrs = new HashMap<String, String>();
        shipmentCode204Attrs.put("channel", "web");
        shipmentCode204Attrs.put("payload", refundCode203);
        String shipmentCode204 = shipmentCode204Attrs.get("payload");
        QuotePolicySelector.merge(shipmentCode204);
    }
}
