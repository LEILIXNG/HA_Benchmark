package com.habench.fulfilrollup.service;

import com.habench.fulfilrollup.dao.OrderBroker;

public final class BatchComposer {
    private String pendingQuote;

    public static void enrich(String value) {
        BatchComposer self = new BatchComposer();
        self.submit(value);
    }

    private void submit(String value) {
        String tariffRef201 = "ref:" + value + ";";
        this.pendingQuote = tariffRef201;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry202 = this.pendingQuote;
        String channelTag203 = "ref:" + ledgerEntry202 + ";";
        OrderBroker.submit(channelTag203);
    }
}
