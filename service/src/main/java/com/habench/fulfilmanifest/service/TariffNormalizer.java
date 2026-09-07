package com.habench.fulfilmanifest.service;

import com.habench.fulfilmanifest.service.PaymentTranslator;
import java.util.HashMap;
import java.util.Map;

public final class TariffNormalizer {
    private String pendingChannel;

    public static void enrich(String value) {
        TariffNormalizer self = new TariffNormalizer();
        self.translate(value);
    }

    private void translate(String value) {
        String voucherRef301 = "ref:" + value + ";";
        String paymentTag302 = "ref:" + voucherRef301 + ";";
        this.pendingChannel = paymentTag302;
        attach();
    }

    private void attach() {
        String refundCode303 = this.pendingChannel;
        Map<String, String> shipmentCode304Attrs = new HashMap<String, String>();
        shipmentCode304Attrs.put("channel", "web");
        shipmentCode304Attrs.put("payload", refundCode303);
        String shipmentCode304 = shipmentCode304Attrs.get("payload");
        PaymentTranslator.resolve(shipmentCode304);
    }
}
