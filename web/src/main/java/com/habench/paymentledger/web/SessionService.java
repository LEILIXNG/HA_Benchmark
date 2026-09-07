package com.habench.paymentledger.web;

import com.habench.paymentledger.web.PaymentPolicy2Selector;
import java.util.HashMap;
import java.util.Map;

public final class SessionService {
    private String pendingBatch;

    public static void submit(String value) {
        SessionService self = new SessionService();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        this.pendingBatch = channelTag1;
        route();
    }

    private void route() {
        String catalogKey2 = this.pendingBatch;
        String receiptKey3 = catalogKey2;
        String accountRef4 = receiptKey3;
        PaymentPolicy2Selector.register(accountRef4);
    }
}
