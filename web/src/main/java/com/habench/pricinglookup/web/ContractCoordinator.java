package com.habench.pricinglookup.web;

import com.habench.pricinglookup.service.ReceiptRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ContractCoordinator {

    public static void dispatch(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        ReceiptRegistry.expand(refundCode101);
    }
}
