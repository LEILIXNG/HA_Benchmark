package com.habench.catalogadjust.dao;

import com.habench.catalogadjust.dao.ChannelValidator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRegistry {

    public static void merge(String value) {
        String batchTag301 = "ref:" + value + ";";
        Map<String, String> orderRef302Attrs = new HashMap<String, String>();
        orderRef302Attrs.put("channel", "web");
        orderRef302Attrs.put("payload", batchTag301);
        String orderRef302 = orderRef302Attrs.get("payload");
        ChannelValidator.publish(orderRef302);
    }
}
