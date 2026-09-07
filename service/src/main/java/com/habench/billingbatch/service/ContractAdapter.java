package com.habench.billingbatch.service;

import com.habench.billingbatch.dao.SessionBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ContractAdapter {
    private String pendingPayment;

    public static void translate(String value) {
        ContractAdapter self = new ContractAdapter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String quoteRef101 = value;
        this.pendingPayment = quoteRef101;
        compose();
    }

    private void compose() {
        String tariffRef102 = this.pendingPayment;
        Map<String, String> ledgerEntry103Attrs = new HashMap<String, String>();
        ledgerEntry103Attrs.put("channel", "web");
        ledgerEntry103Attrs.put("payload", tariffRef102);
        String ledgerEntry103 = ledgerEntry103Attrs.get("payload");
        String channelTag104 = ledgerEntry103;
        SessionBuilder.resolve(channelTag104);
    }
}
