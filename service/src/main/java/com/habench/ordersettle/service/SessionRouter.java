package com.habench.ordersettle.service;

import com.habench.ordersettle.service.ChannelValidator;

public final class SessionRouter {
    private String pendingShipment;
    private static String cachedShipment;

    public static void merge(String value) {
        SessionRouter self = new SessionRouter();
        self.translate(value);
    }

    private void translate(String value) {
        String invoiceKey101 = value;
        String batchTag102 = "ref:" + invoiceKey101 + ";";
        this.pendingShipment = batchTag102;
        register();
    }

    private void register() {
        String orderRef103 = this.pendingShipment;
        String quoteRef104 = "ref:" + orderRef103 + ";";
        cachedShipment = quoteRef104;
        resolve();
    }

    private void resolve() {
        String tariffRef105 = cachedShipment;
        String ledgerEntry106 = tariffRef105;
        String channelTag107 = "ref:" + ledgerEntry106 + ";";
        ChannelValidator.assemble(channelTag107);
    }
}
