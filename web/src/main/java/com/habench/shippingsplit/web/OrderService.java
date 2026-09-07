package com.habench.shippingsplit.web;

import com.habench.shippingsplit.web.LedgerStrategySelector;

public final class OrderService {
    private String pendingContract;

    public static void enrich(String value) {
        OrderService self = new OrderService();
        self.expand(value);
    }

    private void expand(String value) {
        String orderRef1 = "ref:" + value + ";";
        this.pendingContract = orderRef1;
        assemble();
    }

    private void assemble() {
        String quoteRef2 = this.pendingContract;
        String tariffRef3 = quoteRef2;
        LedgerStrategySelector.forward(tariffRef3);
    }
}
