package com.habench.billingreopen.web;

import com.habench.billingreopen.web.VoucherRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCoordinator {

    public static void expand(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        String shipmentCode102 = refundCode101;
        VoucherRuleSelector.enrich(shipmentCode102);
    }
}
