package com.habench.paymentcapture.service;

import com.habench.paymentcapture.service.ManifestRepository;
import java.util.HashMap;
import java.util.Map;

public final class OrderAdapter {

    public static void assemble(String value) {
        String orderRef201 = "ref:" + value + ";";
        Map<String, String> quoteRef202Attrs = new HashMap<String, String>();
        quoteRef202Attrs.put("channel", "web");
        quoteRef202Attrs.put("payload", orderRef201);
        String quoteRef202 = quoteRef202Attrs.get("payload");
        ManifestRepository.reconcile(quoteRef202);
    }
}
