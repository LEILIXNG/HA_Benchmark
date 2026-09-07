package com.habench.paymentsplit.dao;

import com.habench.paymentsplit.dao.RefundExecutor;
import java.util.HashMap;
import java.util.Map;

public final class AccountService {

    public static void stage(String value) {
        Map<String, String> channelTag501Attrs = new HashMap<String, String>();
        channelTag501Attrs.put("channel", "web");
        channelTag501Attrs.put("payload", value);
        String channelTag501 = channelTag501Attrs.get("payload");
        String catalogKey502 = "ref:" + channelTag501 + ";";
        RefundExecutor.forward(catalogKey502);
    }
}
