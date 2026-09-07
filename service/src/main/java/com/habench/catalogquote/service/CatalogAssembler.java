package com.habench.catalogquote.service;

import com.habench.catalogquote.service.TariffLoader;

public final class CatalogAssembler {
    private String pendingTariff;

    public static void compose(String value) {
        CatalogAssembler self = new CatalogAssembler();
        self.publish(value);
    }

    private void publish(String value) {
        String manifestKey201 = value;
        String invoiceKey202 = "ref:" + manifestKey201 + ";";
        this.pendingTariff = invoiceKey202;
        merge();
    }

    private void merge() {
        String batchTag203 = this.pendingTariff;
        String orderRef204 = "ref:" + batchTag203 + ";";
        TariffLoader.enrich(orderRef204);
    }
}
