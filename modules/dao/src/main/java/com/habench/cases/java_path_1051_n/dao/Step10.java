package com.habench.cases.java_path_1051_n.dao;

import com.habench.cases.java_path_1051_n.dao.Sanitizer11;
import java.util.HashMap;
import java.util.Map;

public final class Step10 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Sanitizer11.apply(attributes.get("payload"));
    }
}
