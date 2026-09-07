package com.habench.pricingadjust.dao;

import com.habench.pricingadjust.dao.QuoteValidator;
import java.util.HashMap;
import java.util.Map;

public final class OrderNormalizer {

    public static void enrich(String value) {
        Map<String, String> quoteRef501Attrs = new HashMap<String, String>();
        quoteRef501Attrs.put("channel", "web");
        quoteRef501Attrs.put("payload", value);
        String quoteRef501 = quoteRef501Attrs.get("payload");
        Map<String, String> tariffRef502Attrs = new HashMap<String, String>();
        tariffRef502Attrs.put("channel", "web");
        tariffRef502Attrs.put("payload", quoteRef501);
        String tariffRef502 = tariffRef502Attrs.get("payload");
        QuoteValidator.submit(tariffRef502);
    }
}
