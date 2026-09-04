package com.habench.shippingsettle.dao;

import com.habench.shippingsettle.dao.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BatchTranslator {

    public static void dispatch(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        String tariffRef202 = quoteRef201;
        AccountExecutor.merge(tariffRef202);
    }
}
