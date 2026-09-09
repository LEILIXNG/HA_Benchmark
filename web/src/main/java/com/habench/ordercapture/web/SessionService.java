package com.habench.ordercapture.web;

import com.habench.ordercapture.service.ShipmentTranslator;

public final class SessionService {
    private String pendingSession;

    public static void reconcile(String value) {
        SessionService self = new SessionService();
        self.assemble(value);
    }

    private void assemble(String value) {
        String shipmentCode101 = value;
        this.pendingSession = shipmentCode101;
        attach();
    }

    private void attach() {
        String manifestKey102 = this.pendingSession;
        String invoiceKey103 = "ref:" + manifestKey102 + ";";
        ShipmentTranslator.collect(invoiceKey103);
    }
}
