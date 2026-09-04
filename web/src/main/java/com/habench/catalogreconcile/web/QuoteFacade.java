package com.habench.catalogreconcile.web;

import com.habench.catalogreconcile.service.ChannelRouter;
import java.util.HashMap;
import java.util.Map;

public final class QuoteFacade {

    public static void resolve(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        String channelTag2 = "ref:" + ledgerEntry1 + ";";
        ChannelRouter.register(channelTag2);
    }
}
