package com.habench.vendorsplit.dao;

import com.habench.vendorsplit.dao.VoucherPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {

    public static void publish(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("payload", value);
        String invoiceKey301 = invoiceKey301Attrs.get("payload");
        Map<String, String> batchTag302Attrs = new HashMap<String, String>();
        batchTag302Attrs.put("channel", "web");
        batchTag302Attrs.put("payload", invoiceKey301);
        String batchTag302 = batchTag302Attrs.get("payload");
        VoucherPlanSelector.assemble(batchTag302);
    }
}
