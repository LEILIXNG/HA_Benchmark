package com.habench.customerapprove.service;

import com.habench.customerapprove.service.TariffStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBuilder {

    public static void resolve(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        TariffStrategySelector.compose(shipmentCode101);
    }
}
