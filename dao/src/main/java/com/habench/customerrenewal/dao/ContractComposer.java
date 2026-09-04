package com.habench.customerrenewal.dao;

import com.habench.customerrenewal.dao.QuoteLoader;
import java.util.HashMap;
import java.util.Map;

public final class ContractComposer {

    public static void translate(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("payload", value);
        String quoteRef301 = quoteRef301Attrs.get("payload");
        Map<String, String> tariffRef302Attrs = new HashMap<String, String>();
        tariffRef302Attrs.put("channel", "web");
        tariffRef302Attrs.put("payload", quoteRef301);
        String tariffRef302 = tariffRef302Attrs.get("payload");
        QuoteLoader.route(tariffRef302);
    }
}
