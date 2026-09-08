package com.habench.accountrefund.service;

import com.habench.accountrefund.service.VoucherGateway;
import java.util.HashMap;
import java.util.Map;

public final class ChannelAdapter {

    public static void stage(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        VoucherGateway.merge(shipmentCode101);
    }
}
