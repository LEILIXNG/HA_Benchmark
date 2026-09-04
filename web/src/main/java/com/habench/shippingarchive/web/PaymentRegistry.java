package com.habench.shippingarchive.web;

import com.habench.shippingarchive.service.ShipmentEnricher;

public final class PaymentRegistry {
    private String pendingSession;
    private static String cachedSession;

    public static void stage(String value) {
        PaymentRegistry self = new PaymentRegistry();
        self.collect(value);
    }

    private void collect(String value) {
        String orderRef1 = value;
        this.pendingSession = orderRef1;
        publish();
    }

    private void publish() {
        String quoteRef2 = this.pendingSession;
        String tariffRef3 = "ref:" + quoteRef2 + ";";
        cachedSession = tariffRef3;
        translate();
    }

    private void translate() {
        String ledgerEntry4 = cachedSession;
        String channelTag5 = "ref:" + ledgerEntry4 + ";";
        ShipmentEnricher.prepare(channelTag5);
    }
}
