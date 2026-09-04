package com.habench.reportgrant.dao;

import com.habench.reportgrant.dao.RefundPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRouter {

    public static void compose(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        String refundCode202 = "ref:" + paymentTag201 + ";";
        RefundPlanSelector.translate(refundCode202);
    }
}
