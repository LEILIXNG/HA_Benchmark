package com.habench.vendorbatch.web;

import com.habench.vendorbatch.service.TariffBroker;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBuilder {
    private String pendingRefund;

    public static void dispatch(String value) {
        QuoteBuilder self = new QuoteBuilder();
        self.collect(value);
    }

    private void collect(String value) {
        String catalogKey1 = value;
        this.pendingRefund = catalogKey1;
        reconcile();
    }

    private void reconcile() {
        String receiptKey2 = this.pendingRefund;
        String accountRef3 = "ref:" + receiptKey2 + ";";
        Map<String, String> voucherRef4Attrs = new HashMap<String, String>();
        voucherRef4Attrs.put("channel", "web");
        voucherRef4Attrs.put("payload", accountRef3);
        String voucherRef4 = voucherRef4Attrs.get("payload");
        TariffBroker.translate(voucherRef4);
    }
}
