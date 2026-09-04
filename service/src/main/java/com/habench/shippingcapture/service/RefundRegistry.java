package com.habench.shippingcapture.service;

import com.habench.shippingcapture.service.QuoteStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundRegistry {
    private static String cachedChannel;

    public static void expand(String value) {
        String voucherRef301 = "ref:" + value + ";";
        String paymentTag302 = "ref:" + voucherRef301 + ";";
        cachedChannel = paymentTag302;
        route();
    }

    private static void route() {
        String refundCode303 = cachedChannel;
        Map<String, String> shipmentCode304Attrs = new HashMap<String, String>();
        shipmentCode304Attrs.put("channel", "web");
        shipmentCode304Attrs.put("payload", refundCode303);
        String shipmentCode304 = shipmentCode304Attrs.get("payload");
        QuoteStrategySelector.compose(shipmentCode304);
    }
}
