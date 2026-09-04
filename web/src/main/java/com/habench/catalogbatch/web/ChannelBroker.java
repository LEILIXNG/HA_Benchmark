package com.habench.catalogbatch.web;

import com.habench.catalogbatch.web.TariffCoordinator;

public final class ChannelBroker {
    private String pendingAccount;

    public static void publish(String value) {
        ChannelBroker self = new ChannelBroker();
        self.resolve(value);
    }

    private void resolve(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        this.pendingAccount = ledgerEntry1;
        compose();
    }

    private void compose() {
        String channelTag2 = this.pendingAccount;
        String catalogKey3 = channelTag2;
        String receiptKey4 = catalogKey3;
        TariffCoordinator.publish(receiptKey4);
    }
}
