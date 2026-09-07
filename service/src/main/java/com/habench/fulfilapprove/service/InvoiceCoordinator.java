package com.habench.fulfilapprove.service;

import com.habench.fulfilapprove.service.ShipmentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceCoordinator {
    private String pendingLedger;

    public static void enrich(String value) {
        InvoiceCoordinator self = new InvoiceCoordinator();
        self.route(value);
    }

    private void route(String value) {
        String quoteRef401 = "ref:" + value + ";";
        String tariffRef402 = "ref:" + quoteRef401 + ";";
        this.pendingLedger = tariffRef402;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry403 = this.pendingLedger;
        Map<String, String> channelTag404Attrs = new HashMap<String, String>();
        channelTag404Attrs.put("channel", "web");
        channelTag404Attrs.put("payload", ledgerEntry403);
        String channelTag404 = channelTag404Attrs.get("payload");
        String catalogKey405 = "ref:" + channelTag404 + ";";
        ShipmentStrategySelector.forward(catalogKey405);
    }
}
