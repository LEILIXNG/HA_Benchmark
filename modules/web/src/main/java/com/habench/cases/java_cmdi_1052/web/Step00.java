package com.habench.cases.java_cmdi_1052.web;

import com.habench.cases.java_cmdi_1052.service.Gateway01;
import java.util.HashMap;
import java.util.Map;

public final class Step00 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Gateway01.apply(attributes.get("payload"));
    }
}
