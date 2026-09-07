package com.habench.inventorymanifest.dao;

import com.habench.inventorymanifest.dao.VoucherScreen;
import java.util.HashMap;
import java.util.Map;

public final class TariffRegistry {

    public static void dispatch(String value) {
        Map<String, String> batchTag401Attrs = new HashMap<String, String>();
        batchTag401Attrs.put("channel", "web");
        batchTag401Attrs.put("payload", value);
        String batchTag401 = batchTag401Attrs.get("payload");
        Map<String, String> orderRef402Attrs = new HashMap<String, String>();
        orderRef402Attrs.put("channel", "web");
        orderRef402Attrs.put("payload", batchTag401);
        String orderRef402 = orderRef402Attrs.get("payload");
        VoucherScreen.normalize(orderRef402);
    }
}
