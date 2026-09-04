package com.habench.accountimport.web;

import com.habench.accountimport.service.RefundTranslator;
import java.util.HashMap;
import java.util.Map;

public final class RefundFacade {
    private static String cachedTariff;

    public static void refine(String value) {
        String orderRef1 = "ref:" + value + ";";
        cachedTariff = orderRef1;
        attach();
    }

    private static void attach() {
        String quoteRef2 = cachedTariff;
        String tariffRef3 = "ref:" + quoteRef2 + ";";
        Map<String, String> ledgerEntry4Attrs = new HashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("payload", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.get("payload");
        cachedTariff = ledgerEntry4;
        translate();
    }

    private static void translate() {
        String channelTag5 = cachedTariff;
        String catalogKey6 = "ref:" + channelTag5 + ";";
        cachedTariff = catalogKey6;
        collect();
    }

    private static void collect() {
        String receiptKey7 = cachedTariff;
        String accountRef8 = "ref:" + receiptKey7 + ";";
        String voucherRef9 = "ref:" + accountRef8 + ";";
        RefundTranslator.assemble(voucherRef9);
    }
}
