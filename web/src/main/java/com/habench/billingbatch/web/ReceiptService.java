package com.habench.billingbatch.web;

import com.habench.billingbatch.web.ContractAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {
    private static String cachedPayment;

    public static void submit(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        String tariffRef102 = "ref:" + quoteRef101 + ";";
        cachedPayment = tariffRef102;
        route();
    }

    private static void route() {
        String ledgerEntry103 = cachedPayment;
        Map<String, String> channelTag104Attrs = new HashMap<String, String>();
        channelTag104Attrs.put("channel", "web");
        channelTag104Attrs.put("payload", ledgerEntry103);
        String channelTag104 = channelTag104Attrs.get("payload");
        ContractAdapter.translate(channelTag104);
    }
}
