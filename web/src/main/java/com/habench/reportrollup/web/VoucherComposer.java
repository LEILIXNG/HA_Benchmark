package com.habench.reportrollup.web;

import com.habench.reportrollup.service.RefundFacade;
import java.util.HashMap;
import java.util.Map;

public final class VoucherComposer {

    public static void collect(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        String receiptKey2 = catalogKey1;
        RefundFacade.merge(receiptKey2);
    }
}
