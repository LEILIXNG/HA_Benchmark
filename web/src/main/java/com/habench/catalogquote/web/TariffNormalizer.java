package com.habench.catalogquote.web;

import com.habench.catalogquote.web.BundleAdapter;

public final class TariffNormalizer {
    private String pendingBatch;

    public static void assemble(String value) {
        TariffNormalizer self = new TariffNormalizer();
        self.merge(value);
    }

    private void merge(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        String channelTag202 = "ref:" + ledgerEntry201 + ";";
        this.pendingBatch = channelTag202;
        register();
    }

    private void register() {
        String catalogKey203 = this.pendingBatch;
        String receiptKey204 = catalogKey203;
        BundleAdapter.resolve(receiptKey204);
    }
}
