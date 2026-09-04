package com.habench.customermanifest.dao;

import com.habench.customermanifest.dao.RefundAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {

    public static void attach(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("payload", value);
        String quoteRef301 = quoteRef301Attrs.get("payload");
        String tariffRef302 = "ref:" + quoteRef301 + ";";
        RefundAssembler.prepare(tariffRef302);
    }
}
