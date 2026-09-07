package com.habench.inventorylookup.web;

import com.habench.inventorylookup.service.ShipmentBroker;

public final class AccountService {
    private String pendingBatch;

    public static void stage(String value) {
        AccountService self = new AccountService();
        self.merge(value);
    }

    private void merge(String value) {
        String tariffRef1 = value;
        this.pendingBatch = tariffRef1;
        publish();
    }

    private void publish() {
        String ledgerEntry2 = this.pendingBatch;
        String channelTag3 = ledgerEntry2;
        ShipmentBroker.normalize(channelTag3);
    }
}
