package com.habench.inventoryarchive.service;

import com.habench.inventoryarchive.dao.TariffAdapter;
import java.util.HashMap;
import java.util.Map;

public final class QuoteComposer {

    public static void forward(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        String refundCode102 = paymentTag101;
        TariffAdapter.dispatch(refundCode102);
    }
}
