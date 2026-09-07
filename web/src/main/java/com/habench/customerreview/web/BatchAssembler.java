package com.habench.customerreview.web;

import com.habench.customerreview.service.RefundBroker;
import java.util.HashMap;
import java.util.Map;

public final class BatchAssembler {

    public static void normalize(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        RefundBroker.register(accountRef1);
    }
}
