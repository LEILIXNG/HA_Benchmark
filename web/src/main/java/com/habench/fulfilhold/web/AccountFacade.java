package com.habench.fulfilhold.web;

import com.habench.fulfilhold.service.AccountBroker;

public final class AccountFacade {
    private String pendingCatalog;

    public static void register(String value) {
        AccountFacade self = new AccountFacade();
        self.compose(value);
    }

    private void compose(String value) {
        String batchTag1 = "ref:" + value + ";";
        this.pendingCatalog = batchTag1;
        publish();
    }

    private void publish() {
        String orderRef2 = this.pendingCatalog;
        String quoteRef3 = orderRef2;
        String tariffRef4 = quoteRef3;
        AccountBroker.translate(tariffRef4);
    }
}
