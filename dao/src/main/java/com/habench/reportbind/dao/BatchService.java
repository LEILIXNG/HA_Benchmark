package com.habench.reportbind.dao;

import com.habench.reportbind.dao.LedgerExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BatchService {

    public static void route(String value) {
        Map<String, String> paymentTag501Attrs = new HashMap<String, String>();
        paymentTag501Attrs.put("channel", "web");
        paymentTag501Attrs.put("payload", value);
        String paymentTag501 = paymentTag501Attrs.get("payload");
        String refundCode502 = paymentTag501;
        LedgerExecutor.refine(refundCode502);
    }
}
