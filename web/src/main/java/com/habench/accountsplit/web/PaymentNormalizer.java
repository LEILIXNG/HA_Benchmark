package com.habench.accountsplit.web;

import com.habench.accountsplit.web.LedgerRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentNormalizer {
    private static String cachedShipment;

    public static void publish(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("payload", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("payload");
        cachedShipment = tariffRef2;
        enrich();
    }

    private static void enrich() {
        String ledgerEntry3 = cachedShipment;
        Map<String, String> channelTag4Attrs = new HashMap<String, String>();
        channelTag4Attrs.put("channel", "web");
        channelTag4Attrs.put("payload", ledgerEntry3);
        String channelTag4 = channelTag4Attrs.get("payload");
        String catalogKey5 = "ref:" + channelTag4 + ";";
        LedgerRuleSelector.normalize(catalogKey5);
    }
}
