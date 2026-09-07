package com.habench.reportclose.service;

import com.habench.reportclose.dao.ManifestTranslator;
import java.util.HashMap;
import java.util.Map;

public final class LedgerService {
    private String pendingPayment;

    public static void assemble(String value) {
        LedgerService self = new LedgerService();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> refundCode301Attrs = new HashMap<String, String>();
        refundCode301Attrs.put("channel", "web");
        refundCode301Attrs.put("payload", value);
        String refundCode301 = refundCode301Attrs.get("payload");
        this.pendingPayment = refundCode301;
        expand();
    }

    private void expand() {
        String shipmentCode302 = this.pendingPayment;
        String manifestKey303 = shipmentCode302;
        String invoiceKey304 = "ref:" + manifestKey303 + ";";
        ManifestTranslator.enrich(invoiceKey304);
    }
}
