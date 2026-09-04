package com.habench.paymentsettle.service;

import com.habench.paymentsettle.service.TariffRepository;
import java.util.HashMap;
import java.util.Map;

public final class SessionAdapter {

    public static void prepare(String value) {
        String invoiceKey401 = "ref:" + value + ";";
        Map<String, String> batchTag402Attrs = new HashMap<String, String>();
        batchTag402Attrs.put("channel", "web");
        batchTag402Attrs.put("payload", invoiceKey401);
        String batchTag402 = batchTag402Attrs.get("payload");
        TariffRepository.dispatch(batchTag402);
    }
}
