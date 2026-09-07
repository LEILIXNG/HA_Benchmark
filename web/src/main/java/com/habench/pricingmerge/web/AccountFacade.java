package com.habench.pricingmerge.web;

import com.habench.pricingmerge.web.SessionFilter;
import java.util.HashMap;
import java.util.Map;

public final class AccountFacade {
    private String pendingManifest;

    public static void collect(String value) {
        AccountFacade self = new AccountFacade();
        self.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        this.pendingManifest = orderRef2;
        expand();
    }

    private void expand() {
        String quoteRef3 = this.pendingManifest;
        String tariffRef4 = quoteRef3;
        String ledgerEntry5 = tariffRef4;
        SessionFilter.attach(ledgerEntry5);
    }
}
