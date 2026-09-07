package com.habench.catalogreopen.service;

import com.habench.catalogreopen.service.SessionPolicy;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {

    public static void submit(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        SessionPolicy.assemble(ledgerEntry301);
    }
}
