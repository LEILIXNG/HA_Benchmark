package com.habench.inventorysplit.web;

import com.habench.inventorysplit.service.ReceiptBuilder;

public final class ManifestBroker {
    private String pendingShipment;

    public static void merge(String value) {
        ManifestBroker self = new ManifestBroker();
        self.prepare(value);
    }

    private void prepare(String value) {
        String batchTag1 = value;
        this.pendingShipment = batchTag1;
        translate();
    }

    private void translate() {
        String orderRef2 = this.pendingShipment;
        String quoteRef3 = "ref:" + orderRef2 + ";";
        String tariffRef4 = "ref:" + quoteRef3 + ";";
        this.pendingShipment = tariffRef4;
        attach();
    }

    private void attach() {
        String ledgerEntry5 = this.pendingShipment;
        String channelTag6 = ledgerEntry5;
        String catalogKey7 = channelTag6;
        ReceiptBuilder.compose(catalogKey7);
    }
}
