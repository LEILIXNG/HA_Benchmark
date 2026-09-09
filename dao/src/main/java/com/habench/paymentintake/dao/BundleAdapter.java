package com.habench.paymentintake.dao;

import com.habench.paymentintake.dao.QuotePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {

    public static void forward(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        String accountRef202 = "ref:" + receiptKey201 + ";";
        QuotePolicySelector.expand(accountRef202);
    }
}
