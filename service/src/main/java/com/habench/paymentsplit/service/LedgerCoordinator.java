package com.habench.paymentsplit.service;

import com.habench.paymentsplit.dao.AccountService;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {

    public static void publish(String value) {
        Map<String, String> channelTag501Attrs = new HashMap<String, String>();
        channelTag501Attrs.put("channel", "web");
        channelTag501Attrs.put("payload", value);
        String channelTag501 = channelTag501Attrs.get("payload");
        String catalogKey502 = "ref:" + channelTag501 + ";";
        AccountService.stage(catalogKey502);
    }
}
