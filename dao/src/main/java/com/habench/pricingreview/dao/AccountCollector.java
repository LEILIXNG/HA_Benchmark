package com.habench.pricingreview.dao;

import com.habench.pricingreview.dao.QuoteScreen;
import java.util.HashMap;
import java.util.Map;

public final class AccountCollector {

    public static void attach(String value) {
        Map<String, String> paymentTag501Attrs = new HashMap<String, String>();
        paymentTag501Attrs.put("channel", "web");
        paymentTag501Attrs.put("payload", value);
        String paymentTag501 = paymentTag501Attrs.get("payload");
        String refundCode502 = paymentTag501;
        QuoteScreen.translate(refundCode502);
    }
}
