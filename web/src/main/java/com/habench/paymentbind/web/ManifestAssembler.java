package com.habench.paymentbind.web;

import com.habench.paymentbind.service.TariffService;

public final class ManifestAssembler {
    private String pendingManifest;

    public static void refine(String value) {
        ManifestAssembler self = new ManifestAssembler();
        self.collect(value);
    }

    private void collect(String value) {
        String refundCode1 = "ref:" + value + ";";
        this.pendingManifest = refundCode1;
        prepare();
    }

    private void prepare() {
        String shipmentCode2 = this.pendingManifest;
        String manifestKey3 = "ref:" + shipmentCode2 + ";";
        String invoiceKey4 = manifestKey3;
        TariffService.reconcile(invoiceKey4);
    }
}
