package com.habench.billingmerge.service;

import com.habench.billingmerge.service.CatalogNormalizer;

public final class RefundEnricher {
    private String pendingQuote;

    public static void forward(String value) {
        RefundEnricher self = new RefundEnricher();
        self.expand(value);
    }

    private void expand(String value) {
        String quoteRef101 = "ref:" + value + ";";
        String tariffRef102 = quoteRef101;
        this.pendingQuote = tariffRef102;
        prepare();
    }

    private void prepare() {
        String ledgerEntry103 = this.pendingQuote;
        String channelTag104 = ledgerEntry103;
        String catalogKey105 = "ref:" + channelTag104 + ";";
        CatalogNormalizer.expand(catalogKey105);
    }
}
