package com.habench.fulfildigest.web;

import com.habench.fulfildigest.web.TariffService;

public final class InvoiceEnricher {
    private String pendingVoucher;

    public static void register(String value) {
        InvoiceEnricher self = new InvoiceEnricher();
        self.forward(value);
    }

    private void forward(String value) {
        String shipmentCode1 = value;
        String manifestKey2 = "ref:" + shipmentCode1 + ";";
        this.pendingVoucher = manifestKey2;
        merge();
    }

    private void merge() {
        String invoiceKey3 = this.pendingVoucher;
        String batchTag4 = invoiceKey3;
        String orderRef5 = "ref:" + batchTag4 + ";";
        TariffService.resolve(orderRef5);
    }
}
