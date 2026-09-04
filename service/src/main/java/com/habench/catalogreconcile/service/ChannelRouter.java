package com.habench.catalogreconcile.service;

import com.habench.catalogreconcile.service.OrderStrategySelector;

public final class ChannelRouter {
    private String pendingShipment;
    private static String cachedShipment;

    public static void register(String value) {
        ChannelRouter self = new ChannelRouter();
        self.resolve(value);
    }

    private void resolve(String value) {
        String invoiceKey101 = "ref:" + value + ";";
        this.pendingShipment = invoiceKey101;
        merge();
    }

    private void merge() {
        String batchTag102 = this.pendingShipment;
        String orderRef103 = "ref:" + batchTag102 + ";";
        String quoteRef104 = "ref:" + orderRef103 + ";";
        cachedShipment = quoteRef104;
        submit();
    }

    private void submit() {
        String tariffRef105 = cachedShipment;
        String ledgerEntry106 = tariffRef105;
        String channelTag107 = ledgerEntry106;
        OrderStrategySelector.compose(channelTag107);
    }
}
