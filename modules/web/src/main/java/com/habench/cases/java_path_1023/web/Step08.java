package com.habench.cases.java_path_1023.web;

import com.habench.cases.java_path_1023.web.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Step08 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        SinkHandler.execute(attributes.get("payload"));
    }
}
