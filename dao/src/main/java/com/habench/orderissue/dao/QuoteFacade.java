package com.habench.orderissue.dao;

import com.habench.orderissue.dao.TariffGuard;
import java.util.HashMap;
import java.util.Map;

public final class QuoteFacade {

    public static void assemble(String value) {
        Map<String, String> channelTag401Attrs = new HashMap<String, String>();
        channelTag401Attrs.put("channel", "web");
        channelTag401Attrs.put("payload", value);
        String channelTag401 = channelTag401Attrs.get("payload");
        TariffGuard.compose(channelTag401);
    }
}
