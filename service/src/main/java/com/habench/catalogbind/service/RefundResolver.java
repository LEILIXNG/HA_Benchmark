package com.habench.catalogbind.service;

import com.habench.catalogbind.dao.ShipmentRouter;

public final class RefundResolver {
    private String pendingTariff;

    public static void expand(String value) {
        RefundResolver self = new RefundResolver();
        self.submit(value);
    }

    private void submit(String value) {
        String quoteRef101 = "ref:" + value + ";";
        String tariffRef102 = "ref:" + quoteRef101 + ";";
        this.pendingTariff = tariffRef102;
        publish();
    }

    private void publish() {
        String ledgerEntry103 = this.pendingTariff;
        String channelTag104 = "ref:" + ledgerEntry103 + ";";
        ShipmentRouter.attach(channelTag104);
    }
}
