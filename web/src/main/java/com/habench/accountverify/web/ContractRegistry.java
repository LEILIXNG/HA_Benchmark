package com.habench.accountverify.web;

import com.habench.accountverify.web.PaymentPlanSelector;

public final class ContractRegistry {
    private String pendingBundle;

    public static void enrich(String value) {
        ContractRegistry self = new ContractRegistry();
        self.submit(value);
    }

    private void submit(String value) {
        String channelTag1 = "ref:" + value + ";";
        this.pendingBundle = channelTag1;
        stage();
    }

    private void stage() {
        String catalogKey2 = this.pendingBundle;
        String receiptKey3 = catalogKey2;
        PaymentPlanSelector.dispatch(receiptKey3);
    }
}
