package com.habench.cases.java_path_1014.dao;

import com.habench.cases.java_path_1014.dao.SinkHandler;
import java.util.HashMap;
import java.util.Map;

public final class Step02 {

    public static void apply(String value) {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("channel", "web");
        attributes.put("payload", value);
        SinkHandler.execute(attributes.get("payload"));
    }
}
