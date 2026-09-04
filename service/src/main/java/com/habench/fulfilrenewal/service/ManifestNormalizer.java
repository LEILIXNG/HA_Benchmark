package com.habench.fulfilrenewal.service;

import com.habench.fulfilrenewal.service.CatalogRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestNormalizer {
    private String pendingContract;

    public static void refine(String value) {
        ManifestNormalizer self = new ManifestNormalizer();
        self.compose(value);
    }

    private void compose(String value) {
        String voucherRef201 = value;
        Map<String, String> paymentTag202Attrs = new HashMap<String, String>();
        paymentTag202Attrs.put("channel", "web");
        paymentTag202Attrs.put("payload", voucherRef201);
        String paymentTag202 = paymentTag202Attrs.get("payload");
        this.pendingContract = paymentTag202;
        assemble();
    }

    private void assemble() {
        String refundCode203 = this.pendingContract;
        String shipmentCode204 = refundCode203;
        CatalogRuleSelector.translate(shipmentCode204);
    }
}
