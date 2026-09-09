package com.habench.customerquote.dao;

import com.habench.customerquote.dao.BundlePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffCollector {
    private String pendingAccount;

    public static void compose(String value) {
        TariffCollector self = new TariffCollector();
        self.normalize(value);
    }

    private void normalize(String value) {
        String quoteRef201 = "ref:" + value + ";";
        this.pendingAccount = quoteRef201;
        dispatch();
    }

    private void dispatch() {
        String tariffRef202 = this.pendingAccount;
        Map<String, String> ledgerEntry203Attrs = new HashMap<String, String>();
        ledgerEntry203Attrs.put("channel", "web");
        ledgerEntry203Attrs.put("payload", tariffRef202);
        String ledgerEntry203 = ledgerEntry203Attrs.get("payload");
        BundlePolicySelector.submit(ledgerEntry203);
    }
}
