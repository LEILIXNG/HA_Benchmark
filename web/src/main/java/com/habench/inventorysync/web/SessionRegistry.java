package com.habench.inventorysync.web;

import com.habench.inventorysync.web.ShipmentGuard;

public final class SessionRegistry {
    private String pendingSession;

    public static void expand(String value) {
        SessionRegistry self = new SessionRegistry();
        self.refine(value);
    }

    private void refine(String value) {
        String batchTag101 = "ref:" + value + ";";
        this.pendingSession = batchTag101;
        translate();
    }

    private void translate() {
        String orderRef102 = this.pendingSession;
        String quoteRef103 = orderRef102;
        String tariffRef104 = quoteRef103;
        ShipmentGuard.forward(tariffRef104);
    }
}
