package com.habench.customerverify.service;

import com.habench.customerverify.service.TariffEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class AccountRegistry {
    private String pendingTariff;

    public static void reconcile(String value) {
        AccountRegistry self = new AccountRegistry();
        self.compose(value);
    }

    private void compose(String value) {
        String ledgerEntry301 = value;
        String channelTag302 = "ref:" + ledgerEntry301 + ";";
        this.pendingTariff = channelTag302;
        collect();
    }

    private void collect() {
        String catalogKey303 = this.pendingTariff;
        Map<String, String> receiptKey304Attrs = new HashMap<String, String>();
        receiptKey304Attrs.put("channel", "web");
        receiptKey304Attrs.put("payload", catalogKey303);
        String receiptKey304 = receiptKey304Attrs.get("payload");
        TariffEvaluator.forward(receiptKey304);
    }
}
