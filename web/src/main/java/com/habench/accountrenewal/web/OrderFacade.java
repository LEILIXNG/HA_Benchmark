package com.habench.accountrenewal.web;

import com.habench.accountrenewal.service.PaymentNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class OrderFacade {
    private String pendingContract;

    public static void collect(String value) {
        OrderFacade self = new OrderFacade();
        self.assemble(value);
    }

    private void assemble(String value) {
        String quoteRef1 = "ref:" + value + ";";
        String tariffRef2 = "ref:" + quoteRef1 + ";";
        this.pendingContract = tariffRef2;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry3 = this.pendingContract;
        Map<String, String> channelTag4Attrs = new HashMap<String, String>();
        channelTag4Attrs.put("channel", "web");
        channelTag4Attrs.put("payload", ledgerEntry3);
        String channelTag4 = channelTag4Attrs.get("payload");
        Map<String, String> catalogKey5Attrs = new HashMap<String, String>();
        catalogKey5Attrs.put("channel", "web");
        catalogKey5Attrs.put("payload", channelTag4);
        String catalogKey5 = catalogKey5Attrs.get("payload");
        PaymentNormalizer.assemble(catalogKey5);
    }
}
