package com.habench.orderposting.service;

import com.habench.orderposting.service.AccountEvaluator;

public final class ChannelBroker {
    private String pendingAccount;
    private static String cachedAccount;

    public static void publish(String value) {
        ChannelBroker self = new ChannelBroker();
        self.collect(value);
    }

    private void collect(String value) {
        String orderRef101 = value;
        this.pendingAccount = orderRef101;
        submit();
    }

    private void submit() {
        String quoteRef102 = this.pendingAccount;
        String tariffRef103 = "ref:" + quoteRef102 + ";";
        cachedAccount = tariffRef103;
        attach();
    }

    private void attach() {
        String ledgerEntry104 = cachedAccount;
        String channelTag105 = ledgerEntry104;
        AccountEvaluator.merge(channelTag105);
    }
}
