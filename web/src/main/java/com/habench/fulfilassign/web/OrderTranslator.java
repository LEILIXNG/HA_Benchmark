package com.habench.fulfilassign.web;

import com.habench.fulfilassign.web.ChannelStrategySelector;

public final class OrderTranslator {
    private String pendingContract;

    public static void dispatch(String value) {
        OrderTranslator self = new OrderTranslator();
        self.stage(value);
    }

    private void stage(String value) {
        String manifestKey1 = value;
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        this.pendingContract = invoiceKey2;
        route();
    }

    private void route() {
        String batchTag3 = this.pendingContract;
        String orderRef4 = batchTag3;
        String quoteRef5 = orderRef4;
        ChannelStrategySelector.route(quoteRef5);
    }
}
