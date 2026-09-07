package com.habench.inventoryhold.dao;

import com.habench.inventoryhold.dao.BundleLoader;

public final class AccountCollector {
    private String pendingBundle;

    public static void reconcile(String value) {
        AccountCollector self = new AccountCollector();
        self.refine(value);
    }

    private void refine(String value) {
        String channelTag401 = "ref:" + value + ";";
        this.pendingBundle = channelTag401;
        attach();
    }

    private void attach() {
        String catalogKey402 = this.pendingBundle;
        String receiptKey403 = catalogKey402;
        String accountRef404 = receiptKey403;
        BundleLoader.stage(accountRef404);
    }
}
