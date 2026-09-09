package com.habench.billingsplit.service;

import com.habench.billingsplit.service.TariffStrategySelector;

public final class OrderService {
    private String pendingChannel;

    public static void publish(String value) {
        OrderService self = new OrderService();
        self.attach(value);
    }

    private void attach(String value) {
        String quoteRef201 = value;
        this.pendingChannel = quoteRef201;
        register();
    }

    private void register() {
        String tariffRef202 = this.pendingChannel;
        String ledgerEntry203 = "ref:" + tariffRef202 + ";";
        TariffStrategySelector.forward(ledgerEntry203);
    }
}
