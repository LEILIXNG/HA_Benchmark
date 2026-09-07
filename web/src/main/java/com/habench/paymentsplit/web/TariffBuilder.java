package com.habench.paymentsplit.web;

import com.habench.paymentsplit.web.VoucherRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffBuilder {
    private static String cachedRefund;

    public static void stage(String value) {
        String batchTag1 = value;
        cachedRefund = batchTag1;
        register();
    }

    private static void register() {
        String orderRef2 = cachedRefund;
        Map<String, String> quoteRef3Attrs = new HashMap<String, String>();
        quoteRef3Attrs.put("channel", "web");
        quoteRef3Attrs.put("payload", orderRef2);
        String quoteRef3 = quoteRef3Attrs.get("payload");
        cachedRefund = quoteRef3;
        prepare();
    }

    private static void prepare() {
        String tariffRef4 = cachedRefund;
        String ledgerEntry5 = tariffRef4;
        VoucherRuleSelector.translate(ledgerEntry5);
    }
}
