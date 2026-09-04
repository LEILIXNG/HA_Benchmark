package com.habench.customersubmit.web;

import com.habench.customersubmit.service.BundleComposer;
import java.util.HashMap;
import java.util.Map;

public final class TariffComposer {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void prepare(String value) {
        TariffComposer self = new TariffComposer();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        this.pendingCatalog = shipmentCode1;
        merge();
    }

    private void merge() {
        String manifestKey2 = this.pendingCatalog;
        Map<String, String> invoiceKey3Attrs = new HashMap<String, String>();
        invoiceKey3Attrs.put("channel", "web");
        invoiceKey3Attrs.put("payload", manifestKey2);
        String invoiceKey3 = invoiceKey3Attrs.get("payload");
        cachedCatalog = invoiceKey3;
        submit();
    }

    private void submit() {
        String batchTag4 = cachedCatalog;
        String orderRef5 = "ref:" + batchTag4 + ";";
        String quoteRef6 = "ref:" + orderRef5 + ";";
        BundleComposer.prepare(quoteRef6);
    }
}
