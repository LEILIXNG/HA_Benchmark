package com.habench.cases.java_cmdi_1071.web;

import com.habench.cases.java_cmdi_1071.service.Gateway02;
import java.util.HashMap;
import java.util.Map;

public final class Step01 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Gateway02.apply(attributes.get("payload"));
    }
}
