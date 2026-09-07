package com.habench.inventorysubmit.dao;

import com.habench.inventorysubmit.dao.ShipmentExecutor;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBroker {

    public static void expand(String value) {
        Map<String, String> accountRef301Attrs = new HashMap<String, String>();
        accountRef301Attrs.put("channel", "web");
        accountRef301Attrs.put("payload", value);
        String accountRef301 = accountRef301Attrs.get("payload");
        Map<String, String> voucherRef302Attrs = new HashMap<String, String>();
        voucherRef302Attrs.put("channel", "web");
        voucherRef302Attrs.put("payload", accountRef301);
        String voucherRef302 = voucherRef302Attrs.get("payload");
        ShipmentExecutor.merge(voucherRef302);
    }
}
