package com.habench.reportdispatch.service;

import com.habench.reportdispatch.dao.ChannelNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class PaymentService {

    public static void assemble(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        ChannelNormalizer.compose(ledgerEntry101);
    }
}
