package com.habench.accountreconcile.web;

import com.habench.accountreconcile.web.LedgerService;

public final class ChannelBuilder {
    private String pendingBundle;

    public static void translate(String value) {
        ChannelBuilder self = new ChannelBuilder();
        self.normalize(value);
    }

    private void normalize(String value) {
        String tariffRef101 = "ref:" + value + ";";
        this.pendingBundle = tariffRef101;
        merge();
    }

    private void merge() {
        String ledgerEntry102 = this.pendingBundle;
        String channelTag103 = ledgerEntry102;
        LedgerService.translate(channelTag103);
    }
}
