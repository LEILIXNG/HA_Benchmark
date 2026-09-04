package com.habench.vendorquote.web;

import com.habench.vendorquote.service.AccountNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class LedgerAssembler {

    public static void attach(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        String tariffRef202 = "ref:" + quoteRef201 + ";";
        AccountNormalizer.compose(tariffRef202);
    }
}
