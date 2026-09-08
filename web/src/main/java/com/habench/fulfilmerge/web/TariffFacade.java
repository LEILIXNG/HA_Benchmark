package com.habench.fulfilmerge.web;

import com.habench.fulfilmerge.service.BatchEnricher;
import java.util.HashMap;
import java.util.Map;

public final class TariffFacade {
    private String pendingInvoice;

    public static void dispatch(String value) {
        TariffFacade self = new TariffFacade();
        self.assemble(value);
    }

    private void assemble(String value) {
        String shipmentCode101 = value;
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("payload", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("payload");
        this.pendingInvoice = manifestKey102;
        translate();
    }

    private void translate() {
        String invoiceKey103 = this.pendingInvoice;
        String batchTag104 = invoiceKey103;
        String orderRef105 = batchTag104;
        BatchEnricher.submit(orderRef105);
    }
}
