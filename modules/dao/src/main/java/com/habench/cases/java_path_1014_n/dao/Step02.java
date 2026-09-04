package com.habench.cases.java_path_1014_n.dao;

import com.habench.cases.java_path_1014_n.dao.Sanitizer03;
import java.util.HashMap;
import java.util.Map;

public final class Step02 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        Sanitizer03.apply(attributes.get("payload"));
    }
}
