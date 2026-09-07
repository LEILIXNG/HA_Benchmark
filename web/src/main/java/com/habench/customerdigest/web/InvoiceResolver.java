package com.habench.customerdigest.web;

import com.habench.customerdigest.service.TariffRouter;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {

    public static void normalize(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        TariffRouter.dispatch(paymentTag101);
    }
}
