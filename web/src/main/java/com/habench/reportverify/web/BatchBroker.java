package com.habench.reportverify.web;

import com.habench.reportverify.web.ChannelPlanSelector;

public final class BatchBroker {

    public static void register(String value) {
        String receiptKey101 = "ref:" + value + ";";
        String accountRef102 = receiptKey101;
        ChannelPlanSelector.stage(accountRef102);
    }
}
