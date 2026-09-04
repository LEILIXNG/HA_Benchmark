package com.habench.fulfilassign.web;

import com.habench.fulfilassign.web.CatalogFacade;
import java.util.HashMap;
import java.util.Map;

public final class SessionService {
    private String pendingContract;

    public static void submit(String value) {
        SessionService self = new SessionService();
        self.assemble(value);
    }

    private void assemble(String value) {
        String accountRef101 = "ref:" + value + ";";
        this.pendingContract = accountRef101;
        dispatch();
    }

    private void dispatch() {
        String voucherRef102 = this.pendingContract;
        String paymentTag103 = "ref:" + voucherRef102 + ";";
        String refundCode104 = paymentTag103;
        this.pendingContract = refundCode104;
        collect();
    }

    private void collect() {
        String shipmentCode105 = this.pendingContract;
        Map<String, String> manifestKey106Attrs = new HashMap<String, String>();
        manifestKey106Attrs.put("channel", "web");
        manifestKey106Attrs.put("payload", shipmentCode105);
        String manifestKey106 = manifestKey106Attrs.get("payload");
        String invoiceKey107 = manifestKey106;
        CatalogFacade.submit(invoiceKey107);
    }
}
