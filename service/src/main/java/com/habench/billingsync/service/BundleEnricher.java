package com.habench.billingsync.service;

import com.habench.billingsync.dao.ChannelFacade;
import java.util.HashMap;
import java.util.Map;

public final class BundleEnricher {
    private String pendingReceipt;

    public static void assemble(String value) {
        BundleEnricher self = new BundleEnricher();
        self.enrich(value);
    }

    private void enrich(String value) {
        String orderRef301 = "ref:" + value + ";";
        String quoteRef302 = "ref:" + orderRef301 + ";";
        this.pendingReceipt = quoteRef302;
        compose();
    }

    private void compose() {
        String tariffRef303 = this.pendingReceipt;
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("payload", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("payload");
        ChannelFacade.dispatch(ledgerEntry304);
    }
}
