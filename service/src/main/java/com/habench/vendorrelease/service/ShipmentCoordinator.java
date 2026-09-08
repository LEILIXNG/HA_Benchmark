package com.habench.vendorrelease.service;

import com.habench.vendorrelease.dao.OrderAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCoordinator {

    public static void submit(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        String voucherRef202 = accountRef201;
        OrderAssembler.register(voucherRef202);
    }
}
