package com.habench.accounttransfer.web;

import com.habench.accounttransfer.web.SessionCollector;
import java.util.HashMap;
import java.util.Map;

public final class ContractComposer {

    public static void compose(String value) {
        String orderRef1 = "ref:" + value + ";";
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        SessionCollector.expand(quoteRef2);
    }
}
