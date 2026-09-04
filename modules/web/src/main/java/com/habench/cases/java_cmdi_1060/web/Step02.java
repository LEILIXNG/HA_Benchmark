package com.habench.cases.java_cmdi_1060.web;

import com.habench.cases.java_cmdi_1060.service.Gateway03;
import java.util.HashMap;
import java.util.Map;

public final class Step02 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Gateway03.apply(attributes.get("payload"));
    }
}
