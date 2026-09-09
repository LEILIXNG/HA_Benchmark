package com.habench.reportdispatch.web;

import com.habench.reportdispatch.service.AccountResolver;
import java.util.HashMap;
import java.util.Map;

public final class RefundResolver {
    private String pendingVoucher;

    public static void reconcile(String value) {
        RefundResolver self = new RefundResolver();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        this.pendingVoucher = quoteRef1;
        prepare();
    }

    private void prepare() {
        String tariffRef2 = this.pendingVoucher;
        String ledgerEntry3 = tariffRef2;
        String channelTag4 = ledgerEntry3;
        this.pendingVoucher = channelTag4;
        expand();
    }

    private void expand() {
        String catalogKey5 = this.pendingVoucher;
        String receiptKey6 = catalogKey5;
        AccountResolver.forward(receiptKey6);
    }
}
