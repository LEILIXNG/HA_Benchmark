package com.habench.catalogmerge.service;

import com.habench.catalogmerge.service.AccountRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundComposer {
    private String pendingChannel;
    private static String cachedChannel;

    public static void register(String value) {
        RefundComposer self = new RefundComposer();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String orderRef101 = value;
        cachedChannel = orderRef101;
        merge();
    }

    private void merge() {
        String quoteRef102 = cachedChannel;
        String tariffRef103 = quoteRef102;
        this.pendingChannel = tariffRef103;
        assemble();
    }

    private void assemble() {
        String ledgerEntry104 = this.pendingChannel;
        Map<String, String> channelTag105Attrs = new HashMap<String, String>();
        channelTag105Attrs.put("channel", "web");
        channelTag105Attrs.put("payload", ledgerEntry104);
        String channelTag105 = channelTag105Attrs.get("payload");
        this.pendingChannel = channelTag105;
        resolve();
    }

    private void resolve() {
        String catalogKey106 = this.pendingChannel;
        String receiptKey107 = "ref:" + catalogKey106 + ";";
        String accountRef108 = receiptKey107;
        AccountRuleSelector.forward(accountRef108);
    }
}
