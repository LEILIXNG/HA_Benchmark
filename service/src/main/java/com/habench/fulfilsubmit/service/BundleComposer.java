package com.habench.fulfilsubmit.service;

import com.habench.fulfilsubmit.dao.ShipmentCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class BundleComposer {

    public static void submit(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        ShipmentCoordinator.stage(voucherRef101);
    }
}
