package com.habench.fulfilapprove.service;

import com.habench.fulfilapprove.dao.AccountService;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBuilder {

    public static void forward(String value) {
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("payload", value);
        String tariffRef301 = tariffRef301Attrs.get("payload");
        AccountService.normalize(tariffRef301);
    }
}
