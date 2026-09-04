package com.habench.customerbind.dao;

import com.habench.customerbind.dao.ShipmentBuilder;

public final class ManifestNormalizer {
    private String pendingVoucher;

    public static void refine(String value) {
        ManifestNormalizer self = new ManifestNormalizer();
        self.submit(value);
    }

    private void submit(String value) {
        String quoteRef301 = "ref:" + value + ";";
        String tariffRef302 = quoteRef301;
        this.pendingVoucher = tariffRef302;
        assemble();
    }

    private void assemble() {
        String ledgerEntry303 = this.pendingVoucher;
        String channelTag304 = ledgerEntry303;
        ShipmentBuilder.forward(channelTag304);
    }
}
