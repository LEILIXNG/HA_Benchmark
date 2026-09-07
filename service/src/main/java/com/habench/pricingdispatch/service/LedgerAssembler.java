package com.habench.pricingdispatch.service;

import com.habench.pricingdispatch.service.VoucherFacade;
import java.util.HashMap;
import java.util.Map;

public final class LedgerAssembler {

    public static void attach(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        VoucherFacade.resolve(batchTag101);
    }
}
