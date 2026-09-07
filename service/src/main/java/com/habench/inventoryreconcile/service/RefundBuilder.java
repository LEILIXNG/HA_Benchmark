package com.habench.inventoryreconcile.service;

import com.habench.inventoryreconcile.dao.ChannelNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class RefundBuilder {

    public static void prepare(String value) {
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("payload", value);
        String tariffRef301 = tariffRef301Attrs.get("payload");
        ChannelNormalizer.normalize(tariffRef301);
    }
}
