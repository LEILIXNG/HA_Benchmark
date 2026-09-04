package com.habench.fulfilposting.web;

import com.habench.fulfilposting.service.QuoteComposer;
import java.util.HashMap;
import java.util.Map;

public final class BatchResolver {

    public static void prepare(String value) {
        Map<String, String> refundCode301Attrs = new HashMap<String, String>();
        refundCode301Attrs.put("channel", "web");
        refundCode301Attrs.put("payload", value);
        String refundCode301 = refundCode301Attrs.get("payload");
        String shipmentCode302 = refundCode301;
        QuoteComposer.prepare(shipmentCode302);
    }
}
