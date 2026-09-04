package com.habench.catalogquote.web;

import com.habench.catalogquote.web.TariffNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ManifestFacade {
    private String pendingBatch;

    public static void stage(String value) {
        ManifestFacade self = new ManifestFacade();
        self.collect(value);
    }

    private void collect(String value) {
        String voucherRef101 = "ref:" + value + ";";
        this.pendingBatch = voucherRef101;
        submit();
    }

    private void submit() {
        String paymentTag102 = this.pendingBatch;
        String refundCode103 = "ref:" + paymentTag102 + ";";
        String shipmentCode104 = refundCode103;
        this.pendingBatch = shipmentCode104;
        register();
    }

    private void register() {
        String manifestKey105 = this.pendingBatch;
        Map<String, String> invoiceKey106Attrs = new HashMap<String, String>();
        invoiceKey106Attrs.put("channel", "web");
        invoiceKey106Attrs.put("payload", manifestKey105);
        String invoiceKey106 = invoiceKey106Attrs.get("payload");
        String batchTag107 = invoiceKey106;
        TariffNormalizer.assemble(batchTag107);
    }
}
