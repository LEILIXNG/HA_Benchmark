package com.habench.reportbind.dao;

import com.habench.reportbind.dao.RefundService;
import java.util.HashMap;
import java.util.Map;

public final class VoucherTranslator {

    public static void assemble(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("payload", value);
        String channelTag301 = channelTag301Attrs.get("payload");
        String catalogKey302 = "ref:" + channelTag301 + ";";
        RefundService.enrich(catalogKey302);
    }
}
