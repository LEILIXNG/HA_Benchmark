package com.habench.reportissue.web;

import com.habench.reportissue.web.QuotePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchEnricher {

    public static void refine(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        QuotePlanSelector.merge(tariffRef1);
    }
}
