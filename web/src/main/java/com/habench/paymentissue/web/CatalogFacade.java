package com.habench.paymentissue.web;

import com.habench.paymentissue.web.TariffFetcher;

public final class CatalogFacade {
    private String pendingTariff;

    public static void resolve(String value) {
        CatalogFacade self = new CatalogFacade();
        self.assemble(value);
    }

    private void assemble(String value) {
        String voucherRef101 = "ref:" + value + ";";
        this.pendingTariff = voucherRef101;
        translate();
    }

    private void translate() {
        String paymentTag102 = this.pendingTariff;
        String refundCode103 = paymentTag102;
        String shipmentCode104 = refundCode103;
        TariffFetcher.normalize(shipmentCode104);
    }
}
