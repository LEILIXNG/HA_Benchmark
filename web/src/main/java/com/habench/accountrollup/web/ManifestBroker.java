package com.habench.accountrollup.web;

import com.habench.accountrollup.service.BundleAdapter2;

public final class ManifestBroker {
    private String pendingContract;

    public static void refine(String value) {
        ManifestBroker self = new ManifestBroker();
        self.compose(value);
    }

    private void compose(String value) {
        String ledgerEntry1 = value;
        String channelTag2 = "ref:" + ledgerEntry1 + ";";
        this.pendingContract = channelTag2;
        attach();
    }

    private void attach() {
        String catalogKey3 = this.pendingContract;
        String receiptKey4 = catalogKey3;
        BundleAdapter2.register(receiptKey4);
    }
}
