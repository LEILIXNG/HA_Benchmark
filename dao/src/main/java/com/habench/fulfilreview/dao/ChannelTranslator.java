package com.habench.fulfilreview.dao;

import com.habench.fulfilreview.dao.InvoiceRepository;
import java.util.HashMap;
import java.util.Map;

public final class ChannelTranslator {

    public static void resolve(String value) {
        Map<String, String> paymentTag401Attrs = new HashMap<String, String>();
        paymentTag401Attrs.put("channel", "web");
        paymentTag401Attrs.put("payload", value);
        String paymentTag401 = paymentTag401Attrs.get("payload");
        String refundCode402 = "ref:" + paymentTag401 + ";";
        InvoiceRepository.stage(refundCode402);
    }
}
