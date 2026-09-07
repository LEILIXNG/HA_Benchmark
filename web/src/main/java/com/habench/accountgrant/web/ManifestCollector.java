package com.habench.accountgrant.web;

import com.habench.accountgrant.web.TariffRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestCollector {
    private String pendingTariff;
    private static String cachedTariff;

    public static void refine(String value) {
        ManifestCollector self = new ManifestCollector();
        self.compose(value);
    }

    private void compose(String value) {
        String paymentTag1 = "ref:" + value + ";";
        String refundCode2 = paymentTag1;
        this.pendingTariff = refundCode2;
        attach();
    }

    private void attach() {
        String shipmentCode3 = this.pendingTariff;
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("payload", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("payload");
        cachedTariff = manifestKey4;
        dispatch();
    }

    private void dispatch() {
        String invoiceKey5 = cachedTariff;
        Map<String, String> batchTag6Attrs = new HashMap<String, String>();
        batchTag6Attrs.put("channel", "web");
        batchTag6Attrs.put("payload", invoiceKey5);
        String batchTag6 = batchTag6Attrs.get("payload");
        TariffRepository.enrich(batchTag6);
    }
}
