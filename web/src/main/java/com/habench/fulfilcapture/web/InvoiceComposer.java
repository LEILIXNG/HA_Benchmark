package com.habench.fulfilcapture.web;

import com.habench.fulfilcapture.service.TariffAssembler;

public final class InvoiceComposer {
    private String pendingTariff;

    public static void translate(String value) {
        InvoiceComposer self = new InvoiceComposer();
        self.collect(value);
    }

    private void collect(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        String manifestKey2 = "ref:" + shipmentCode1 + ";";
        this.pendingTariff = manifestKey2;
        publish();
    }

    private void publish() {
        String invoiceKey3 = this.pendingTariff;
        String batchTag4 = "ref:" + invoiceKey3 + ";";
        String orderRef5 = "ref:" + batchTag4 + ";";
        TariffAssembler.attach(orderRef5);
    }
}
