package com.habench.shippingsettle.service;

import com.habench.shippingsettle.dao.ManifestService;
import java.util.HashMap;
import java.util.Map;

public final class BundleNormalizer {
    private String pendingTariff;
    private static String cachedTariff;

    public static void submit(String value) {
        BundleNormalizer self = new BundleNormalizer();
        self.expand(value);
    }

    private void expand(String value) {
        String accountRef201 = value;
        String voucherRef202 = "ref:" + accountRef201 + ";";
        cachedTariff = voucherRef202;
        collect();
    }

    private void collect() {
        String paymentTag203 = cachedTariff;
        Map<String, String> refundCode204Attrs = new HashMap<String, String>();
        refundCode204Attrs.put("channel", "web");
        refundCode204Attrs.put("payload", paymentTag203);
        String refundCode204 = refundCode204Attrs.get("payload");
        String shipmentCode205 = "ref:" + refundCode204 + ";";
        this.pendingTariff = shipmentCode205;
        attach();
    }

    private void attach() {
        String manifestKey206 = this.pendingTariff;
        Map<String, String> invoiceKey207Attrs = new HashMap<String, String>();
        invoiceKey207Attrs.put("channel", "web");
        invoiceKey207Attrs.put("payload", manifestKey206);
        String invoiceKey207 = invoiceKey207Attrs.get("payload");
        Map<String, String> batchTag208Attrs = new HashMap<String, String>();
        batchTag208Attrs.put("channel", "web");
        batchTag208Attrs.put("payload", invoiceKey207);
        String batchTag208 = batchTag208Attrs.get("payload");
        ManifestService.attach(batchTag208);
    }
}
