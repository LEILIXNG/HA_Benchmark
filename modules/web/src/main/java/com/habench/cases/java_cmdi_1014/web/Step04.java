package com.habench.cases.java_cmdi_1014.web;

import com.habench.cases.java_cmdi_1014.service.Gateway05;
import java.util.HashMap;
import java.util.Map;

public final class Step04 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Gateway05.apply(attributes.get("payload"));
    }
}
