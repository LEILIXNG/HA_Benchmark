package com.habench.vendorsync.service;

import com.habench.vendorsync.dao.BatchFacade;

public final class AccountAdapter {
    private String pendingBatch;

    public static void normalize(String value) {
        AccountAdapter self = new AccountAdapter();
        self.stage(value);
    }

    private void stage(String value) {
        String channelTag201 = "ref:" + value + ";";
        this.pendingBatch = channelTag201;
        register();
    }

    private void register() {
        String catalogKey202 = this.pendingBatch;
        String receiptKey203 = "ref:" + catalogKey202 + ";";
        String accountRef204 = receiptKey203;
        BatchFacade.compose(accountRef204);
    }
}
