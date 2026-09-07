package com.habench.customerhold.dao;

import com.habench.customerhold.dao.QuoteLoader;

public final class ChannelBuilder {
    private String pendingQuote;

    public static void normalize(String value) {
        ChannelBuilder self = new ChannelBuilder();
        self.enrich(value);
    }

    private void enrich(String value) {
        String channelTag301 = "ref:" + value + ";";
        this.pendingQuote = channelTag301;
        register();
    }

    private void register() {
        String catalogKey302 = this.pendingQuote;
        String receiptKey303 = catalogKey302;
        QuoteLoader.route(receiptKey303);
    }
}
