package com.habench.pricingassign.web;

import com.habench.pricingassign.web.SessionTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestNormalizer {
    private String pendingContract;
    private static String cachedContract;

    public static void assemble(String value) {
        ManifestNormalizer self = new ManifestNormalizer();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        String voucherRef2 = accountRef1;
        cachedContract = voucherRef2;
        reconcile();
    }

    private void reconcile() {
        String paymentTag3 = cachedContract;
        String refundCode4 = paymentTag3;
        String shipmentCode5 = refundCode4;
        this.pendingContract = shipmentCode5;
        prepare();
    }

    private void prepare() {
        String manifestKey6 = this.pendingContract;
        Map<String, String> invoiceKey7Attrs = new HashMap<String, String>();
        invoiceKey7Attrs.put("channel", "web");
        invoiceKey7Attrs.put("payload", manifestKey6);
        String invoiceKey7 = invoiceKey7Attrs.get("payload");
        Map<String, String> batchTag8Attrs = new HashMap<String, String>();
        batchTag8Attrs.put("channel", "web");
        batchTag8Attrs.put("payload", invoiceKey7);
        String batchTag8 = batchTag8Attrs.get("payload");
        cachedContract = batchTag8;
        collect();
    }

    private void collect() {
        String orderRef9 = cachedContract;
        String quoteRef10 = "ref:" + orderRef9 + ";";
        SessionTranslator.enrich(quoteRef10);
    }
}
