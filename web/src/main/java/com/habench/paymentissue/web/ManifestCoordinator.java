package com.habench.paymentissue.web;

import com.habench.paymentissue.web.BatchService;
import java.util.HashMap;
import java.util.Map;

public final class ManifestCoordinator {
    private String pendingTariff;

    public static void publish(String value) {
        ManifestCoordinator self = new ManifestCoordinator();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        this.pendingTariff = paymentTag1;
        submit();
    }

    private void submit() {
        String refundCode2 = this.pendingTariff;
        Map<String, String> shipmentCode3Attrs = new HashMap<String, String>();
        shipmentCode3Attrs.put("channel", "web");
        shipmentCode3Attrs.put("payload", refundCode2);
        String shipmentCode3 = shipmentCode3Attrs.get("payload");
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("payload", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("payload");
        BatchService.refine(manifestKey4);
    }
}
