package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.web.TariffPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherEnricher {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void stage(String value) {
        VoucherEnricher self = new VoucherEnricher();
        self.collect(value);
    }

    private void collect(String value) {
        String quoteRef201 = value;
        String tariffRef202 = "ref:" + quoteRef201 + ";";
        cachedReceipt = tariffRef202;
        resolve();
    }

    private void resolve() {
        String ledgerEntry203 = cachedReceipt;
        String channelTag204 = ledgerEntry203;
        String catalogKey205 = "ref:" + channelTag204 + ";";
        this.pendingReceipt = catalogKey205;
        register();
    }

    private void register() {
        String receiptKey206 = this.pendingReceipt;
        Map<String, String> accountRef207Attrs = new HashMap<String, String>();
        accountRef207Attrs.put("channel", "web");
        accountRef207Attrs.put("payload", receiptKey206);
        String accountRef207 = accountRef207Attrs.get("payload");
        String voucherRef208 = accountRef207;
        TariffPlanSelector.register(voucherRef208);
    }
}
