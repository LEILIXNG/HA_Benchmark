package com.habench.pricingsplit.web;

import com.habench.pricingsplit.service.BatchGuard;

public final class AccountTranslator {
    private String pendingBundle;

    public static void attach(String value) {
        AccountTranslator self = new AccountTranslator();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String channelTag1 = "ref:" + value + ";";
        this.pendingBundle = channelTag1;
        stage();
    }

    private void stage() {
        String catalogKey2 = this.pendingBundle;
        String receiptKey3 = catalogKey2;
        BatchGuard.stage(receiptKey3);
    }
}
