package com.habench.fulfilassign.web;

import com.habench.fulfilassign.web.QuoteBroker;

public final class CatalogFacade {
    private String pendingContract;

    public static void submit(String value) {
        CatalogFacade self = new CatalogFacade();
        self.translate(value);
    }

    private void translate(String value) {
        String tariffRef201 = "ref:" + value + ";";
        String ledgerEntry202 = "ref:" + tariffRef201 + ";";
        this.pendingContract = ledgerEntry202;
        resolve();
    }

    private void resolve() {
        String channelTag203 = this.pendingContract;
        String catalogKey204 = channelTag203;
        QuoteBroker.submit(catalogKey204);
    }
}
