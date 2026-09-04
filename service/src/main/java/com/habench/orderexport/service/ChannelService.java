package com.habench.orderexport.service;

import com.habench.orderexport.dao.LedgerAdapter;

public final class ChannelService {
    private String pendingChannel;

    public static void forward(String value) {
        ChannelService self = new ChannelService();
        self.compose(value);
    }

    private void compose(String value) {
        String channelTag201 = "ref:" + value + ";";
        this.pendingChannel = channelTag201;
        collect();
    }

    private void collect() {
        String catalogKey202 = this.pendingChannel;
        String receiptKey203 = catalogKey202;
        String accountRef204 = receiptKey203;
        LedgerAdapter.route(accountRef204);
    }
}
