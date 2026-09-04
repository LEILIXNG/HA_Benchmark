package com.habench.cases.java_cmdi_1017_n.dao;

import com.habench.cases.java_cmdi_1017_n.dao.Sanitizer07;
import java.util.HashMap;
import java.util.Map;

public final class Step06 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Sanitizer07.apply(attributes.get("payload"));
    }
}
