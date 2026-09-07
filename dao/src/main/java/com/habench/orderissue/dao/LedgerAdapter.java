package com.habench.orderissue.dao;

import com.habench.orderissue.dao.BundleBroker;
import java.util.HashMap;
import java.util.Map;

public final class LedgerAdapter {

    public static void forward(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        String orderRef202 = "ref:" + batchTag201 + ";";
        BundleBroker.resolve(orderRef202);
    }
}
