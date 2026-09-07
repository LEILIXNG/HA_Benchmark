package com.habench.shippingsettle.web;

import com.habench.shippingsettle.service.BundleNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class LedgerAssembler {
    private String pendingTariff;

    public static void dispatch(String value) {
        LedgerAssembler self = new LedgerAssembler();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("payload", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("payload");
        this.pendingTariff = invoiceKey102;
        register();
    }

    private void register() {
        String batchTag103 = this.pendingTariff;
        String orderRef104 = batchTag103;
        String quoteRef105 = "ref:" + orderRef104 + ";";
        BundleNormalizer.submit(quoteRef105);
    }
}
