package com.habench.customerreview.dao;

import com.habench.customerreview.dao.TariffScreen;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {

    public static void compose(String value) {
        Map<String, String> paymentTag501Attrs = new HashMap<String, String>();
        paymentTag501Attrs.put("channel", "web");
        paymentTag501Attrs.put("payload", value);
        String paymentTag501 = paymentTag501Attrs.get("payload");
        TariffScreen.expand(paymentTag501);
    }
}
