package com.habench.catalogadjust.service;

import com.habench.catalogadjust.service.QuoteStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherService {

    public static void prepare(String value) {
        String paymentTag101 = value;
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        QuoteStrategySelector.dispatch(refundCode102);
    }
}
