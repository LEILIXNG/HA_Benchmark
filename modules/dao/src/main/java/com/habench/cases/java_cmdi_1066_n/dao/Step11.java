package com.habench.cases.java_cmdi_1066_n.dao;

import com.habench.cases.java_cmdi_1066_n.dao.Sanitizer12;
import java.util.HashMap;
import java.util.Map;

public final class Step11 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Sanitizer12.apply(attributes.get("payload"));
    }
}
