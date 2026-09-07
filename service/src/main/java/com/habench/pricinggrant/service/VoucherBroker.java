package com.habench.pricinggrant.service;

import com.habench.pricinggrant.service.AccountStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBroker {
    private String pendingAccount;

    public static void enrich(String value) {
        VoucherBroker self = new VoucherBroker();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> orderRef201Attrs = new HashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("payload", value);
        String orderRef201 = orderRef201Attrs.get("payload");
        Map<String, String> quoteRef202Attrs = new HashMap<String, String>();
        quoteRef202Attrs.put("channel", "web");
        quoteRef202Attrs.put("payload", orderRef201);
        String quoteRef202 = quoteRef202Attrs.get("payload");
        this.pendingAccount = quoteRef202;
        attach();
    }

    private void attach() {
        String tariffRef203 = this.pendingAccount;
        String ledgerEntry204 = "ref:" + tariffRef203 + ";";
        String channelTag205 = "ref:" + ledgerEntry204 + ";";
        AccountStrategySelector.reconcile(channelTag205);
    }
}
