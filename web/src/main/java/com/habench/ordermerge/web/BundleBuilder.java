package com.habench.ordermerge.web;

import com.habench.ordermerge.service.TariffEnricher;

public final class BundleBuilder {
    private String pendingTariff;

    public static void resolve(String value) {
        BundleBuilder self = new BundleBuilder();
        self.forward(value);
    }

    private void forward(String value) {
        String orderRef1 = value;
        this.pendingTariff = orderRef1;
        dispatch();
    }

    private void dispatch() {
        String quoteRef2 = this.pendingTariff;
        String tariffRef3 = "ref:" + quoteRef2 + ";";
        String ledgerEntry4 = "ref:" + tariffRef3 + ";";
        TariffEnricher.collect(ledgerEntry4);
    }
}
