package com.habench.billingdispatch.web;

import com.habench.billingdispatch.web.LedgerRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffBroker {
    private String pendingChannel;

    public static void register(String value) {
        TariffBroker self = new TariffBroker();
        self.submit(value);
    }

    private void submit(String value) {
        String channelTag1 = value;
        this.pendingChannel = channelTag1;
        reconcile();
    }

    private void reconcile() {
        String catalogKey2 = this.pendingChannel;
        Map<String, String> receiptKey3Attrs = new HashMap<String, String>();
        receiptKey3Attrs.put("channel", "web");
        receiptKey3Attrs.put("payload", catalogKey2);
        String receiptKey3 = receiptKey3Attrs.get("payload");
        Map<String, String> accountRef4Attrs = new HashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("payload", receiptKey3);
        String accountRef4 = accountRef4Attrs.get("payload");
        this.pendingChannel = accountRef4;
        normalize();
    }

    private void normalize() {
        String voucherRef5 = this.pendingChannel;
        String paymentTag6 = "ref:" + voucherRef5 + ";";
        LedgerRuleSelector.refine(paymentTag6);
    }
}
