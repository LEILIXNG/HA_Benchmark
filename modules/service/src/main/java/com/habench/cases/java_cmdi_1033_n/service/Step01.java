package com.habench.cases.java_cmdi_1033_n.service;

import com.habench.cases.java_cmdi_1033_n.service.Sanitizer02;
import java.util.HashMap;
import java.util.Map;

public final class Step01 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Sanitizer02.apply(attributes.get("payload"));
    }
}
