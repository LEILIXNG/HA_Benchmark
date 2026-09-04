package com.habench.fulfilquote.dao;

import com.habench.fulfilquote.dao.TariffExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {

    public static void assemble(String value) {
        String quoteRef401 = "ref:" + value + ";";
        Map<String, String> tariffRef402Attrs = new HashMap<String, String>();
        tariffRef402Attrs.put("channel", "web");
        tariffRef402Attrs.put("payload", quoteRef401);
        String tariffRef402 = tariffRef402Attrs.get("payload");
        TariffExecutor.prepare(tariffRef402);
    }
}
