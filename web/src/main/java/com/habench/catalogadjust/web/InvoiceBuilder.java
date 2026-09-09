package com.habench.catalogadjust.web;

import com.habench.catalogadjust.service.VoucherService;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBuilder {

    public static void attach(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        VoucherService.prepare(orderRef2);
    }
}
