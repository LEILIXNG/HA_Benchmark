package com.habench.billingmerge.service;

import com.habench.billingmerge.service.QuoteRepository;

public final class CatalogNormalizer {
    private String pendingQuote;

    public static void expand(String value) {
        CatalogNormalizer self = new CatalogNormalizer();
        self.stage(value);
    }

    private void stage(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        this.pendingQuote = shipmentCode201;
        prepare();
    }

    private void prepare() {
        String manifestKey202 = this.pendingQuote;
        String invoiceKey203 = "ref:" + manifestKey202 + ";";
        QuoteRepository.route(invoiceKey203);
    }
}
